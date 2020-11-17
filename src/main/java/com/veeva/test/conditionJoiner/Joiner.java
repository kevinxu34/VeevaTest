package com.veeva.test.conditionJoiner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.veeva.test.conditionJoiner.conjunction.ConjunctionHandler;
import com.veeva.test.conditionJoiner.conjunction.ConjunctionHandlerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.veeva.test.conditionJoiner.model.Expression;


public class Joiner {
    private Logger logger = LoggerFactory.getLogger(Joiner.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String join(String jsonString) throws JsonProcessingException {
        Expression exp = objectMapper.readValue(jsonString, Expression.class);
        logger.info(exp.toString());

//        ConjunctionHandler conjunctionHandler = ConjunctionHandlerFactory.getConjunctionHandler(exp.getConjunction());
//        if(conjunctionHandler != null) {
//            return conjunctionHandler.join(exp.getConditions());
//        }

        String errorMsg = "There is no pre-defined conjunction.";
        logger.error(errorMsg);
        return errorMsg;

    }
}
