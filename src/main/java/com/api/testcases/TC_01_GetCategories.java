package com.api.testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.testng.Assert;

public class TC_01_GetCategories {

    @Test
    public void getCatogories() throws ParseException {
        RestAssured.baseURI="https://api.predic8.de:443";
        String resource="/shop/categories/";
        Response response=RestAssured.given()
                .when()
                .get(resource)
                .then()
                .extract()
                .response();
//        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200,"Getting Categories Fail");
//        System.out.println(response.getBody().prettyPrint());

        String jsonString=response.getBody().asString();
        ReadJson readJson=new ReadJson();
        readJson.getJsonValue(jsonString, "categories");
    }
}
