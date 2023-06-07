package com.api.testcases;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public  JSONObject  readJson(String fileName) throws Exception {
        if(fileName.endsWith(".json")) fileName=fileName.replace(".json"," ");
        File file=new File("src/main/resources/Testdata/Testdata.json");
        FileReader reader = new FileReader(file);

        JSONParser jsonparser=new JSONParser();

        JSONObject jsonobj=(JSONObject) jsonparser.parse(reader);
//        System.out.println(jsonobj.get("firstName"));
//
//        System.out.println(jsonobj.get("address"));
//            jsonobj=(JSONObject) jsonobj.get("address");
//        System.out.println(jsonobj.get("streetAddress"));

//        System.out.println(jsonobj.get("phoneNumbers"));
//        JSONArray array=(JSONArray) jsonobj.get("phoneNumbers");
////        System.out.println(array.get(0));
////        jsonobj=(JSONObject) array.get(0);
////        System.out.println("type");
//
//        for(int i=0; i< array.size(); i++){
//            jsonobj=(JSONObject) array.get(i);
//            System.out.println(jsonobj.get("type")+"-------"+jsonobj.get("number"));
//        }
        return jsonobj;

    }

    public String getJsonValue(String jsonData, String... key) throws ParseException {
        JSONParser jsonParser=new JSONParser();
       JSONObject jsonObject=(JSONObject) jsonParser.parse(jsonData);

       return jsonObject.get(key[0]).toString();

    }
}
