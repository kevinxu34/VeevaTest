package com.veeva.test.conditionJoiner;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JoinerTest {
    Joiner joiner;

    @BeforeClass
    public void init() {
        joiner = new Joiner();
    }

    private String readFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] encoded = Files.readAllBytes(path);
        return new String(encoded, StandardCharsets.UTF_8);
    }

    @Test
    public void testSimple() throws IOException {
        String jsonString = readFile("src/test/resources/test1.json");
        Assert.assertEquals(joiner.join(jsonString), "(NOT Country_vod__c like '%a%') AND Account_vod__r.Name like '%b%' AND QA_Field_04__c >= 2020-09-18T16:00:00.000Z AND QA_Field_02__c = CNY1");
    }

    @Test
    public void testNested() throws IOException {
        String jsonString = readFile("src/test/resources/test2.json");
        Assert.assertEquals(joiner.join(jsonString), "(((Country_vod__c like '%a%' AND (NOT Email_vod__c like '%b%')) OR (City_vod__c = 'c' AND Name != 'd')) AND Address_Line_1_vod__c < 'e') OR (Address_Line_1_vod__c > 'f' AND Address_Line_2_vod__c <= 'g') OR (Call2_vod__r.Name >= 'h' AND City_vod__c like 'i%')");
    }

    @Test
    public void testNestedSimple() throws IOException {
        String jsonString = readFile("src/test/resources/test3.json");
        Assert.assertEquals(joiner.join(jsonString), "(A = 'a' AND B != 'b') OR (C = 'c' AND D != 'd')");
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = ".*No enum constant.*")
    public void testIncorrectJsonFormat_Conjunction() throws IOException {
        String jsonString = readFile("src/test/resources/test4.json");
        Assert.assertEquals(joiner.join(jsonString),"");
    }

    @Test(expectedExceptions = InvalidFormatException.class,
            expectedExceptionsMessageRegExp = ".*not one of the values accepted for Enum class.*")
    public void testIncorrectJsonFormat_Operator() throws IOException {
        String jsonString = readFile("src/test/resources/test5.json");
        Assert.assertEquals(joiner.join(jsonString),"");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = ".*ERROR: Json Format.*")
    public void testIncorrectJsonFormat_not_conjunction_or_field() throws IOException {
        String jsonString = readFile("src/test/resources/test6.json");
        Assert.assertEquals(joiner.join(jsonString),"");
    }

}