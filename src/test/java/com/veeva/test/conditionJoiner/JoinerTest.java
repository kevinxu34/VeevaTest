package com.veeva.test.conditionJoiner;

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
    public void test1() throws IOException {
        String jsonString = readFile("src/test/resources/test1.json");
        Assert.assertEquals(joiner.join(jsonString), "(NOT Country_vod__c like '%a%') AND Account_vod__r.Name like '%b%' AND QA_Field_04__c >= 2020-09-18T16:00:00.000Z AND QA_Field_02__c = CNY1");
    }

    @Test
    public void test2() throws IOException {
        String jsonString = readFile("src/test/resources/test2.json");
        Assert.assertEquals(joiner.join(jsonString), "abc");
    }

}