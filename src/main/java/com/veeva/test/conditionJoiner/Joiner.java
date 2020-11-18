package com.veeva.test.conditionJoiner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.veeva.test.conditionJoiner.conjunction.ConjunctionHandler;
import com.veeva.test.conditionJoiner.conjunction.ConjunctionHandlerFactory;
import com.veeva.test.conditionJoiner.model.Condition;
import com.veeva.test.conditionJoiner.model.Conjunction;
import com.veeva.test.conditionJoiner.operator.OperatorFactory;
import com.veeva.test.conditionJoiner.operator.OperatorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility to join the condition
 */
public class Joiner {
    private Logger logger = LoggerFactory.getLogger(Joiner.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Join the condition by the conjunction from the JSON string
     * @param jsonString
     * @return the string joined
     * @throws JsonProcessingException
     */
    public String join(String jsonString) throws JsonProcessingException {
        if(jsonString == null || jsonString.isEmpty()) {
            return "";
        }
        JsonNode root = objectMapper.readTree(jsonString);
        return join(root, 0);
    }

    private String join(JsonNode node, int level) throws JsonProcessingException {

        /**
         * Handling the following object
         *
         * {
         *   field: "",
         *   operator: "",
         *   values: []
         * }
         */
        JsonNode fieldNode = node.path("field");
        if(!fieldNode.isMissingNode()) {
            Condition condition = objectMapper.treeToValue(node, Condition.class);
            OperatorHandler operatorHandler = OperatorFactory.getOperatorHandler(condition.getOperator());
            // assume there is only one value in the values array
            return operatorHandler.join(condition.getField(), condition.getValues().get(0));
        }

        /**
         * Handle the following object
         *
         * {
         *   conditions: [],
         *   conjunction: ""
         * }
         */
        JsonNode conjunctionNode = node.path("conjunction");
        if(!conjunctionNode.isMissingNode()) {
            ConjunctionHandler conjunctionHandler = ConjunctionHandlerFactory.getConjunctionHandler(Conjunction.valueOf(conjunctionNode.asText()));

            JsonNode conditionsNode = node.path("conditions");
            List<String> conditionStrs = new ArrayList<>();
            if(conditionsNode.isArray()) {
                for (JsonNode conditionNode : conditionsNode) {
                    String conditionString = join(conditionNode, level +1);
                    conditionStrs.add(conditionString);
                }
                return conjunctionHandler.join(conditionStrs, level);
            }
        }

        throw new RuntimeException("ERROR: Json Format.");

    }

}
