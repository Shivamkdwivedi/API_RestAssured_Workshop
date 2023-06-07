package com.api.testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.junit.Test;

public class TC_02_CreateUser {

    @Test
    public void createUser() throws Exception {
        RestAssured.baseURI="https://api.predic8.de:443";
        String resource="/shop/customers/";
        ReadJson readjson=new ReadJson();
        JSONObject createUserPayload=readjson.readJson("createuser");
//        System.out.println(createUserPayload);

       Response response= RestAssured
                .given()
               .contentType(ContentType.JSON)
                .body(createUserPayload)
                .when()
                .post(resource)
                .then()
                .extract()
                .response();

//        System.out.println(response.getStatusCode());

        String cutUrl=readjson.getJsonValue(response.asString(),"customer_url");
        System.out.println(cutUrl.replaceAll("[^\\d]"," "));

    }
}
