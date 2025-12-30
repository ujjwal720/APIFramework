package tests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Objects;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Practice {

    RequestSpecification specification;


    @BeforeTest
    public void bst(){

        specification=given().contentType("application/json").baseUri(
                "https://petstore.swagger.io/v2");

    }



    @Test
    public void test1(){

     Response a=   given().spec(specification).body("{\n" +
             "  \"id\": 0,\n" +
             "  \"category\": {\n" +
             "    \"id\": 0,\n" +
             "    \"name\": \"string\"\n" +
             "  },\n" +
             "  \"name\": \"doggie\",\n" +
             "  \"photoUrls\": [\n" +
             "    \"string\"\n" +
             "  ],\n" +
             "  \"tags\": [\n" +
             "    {\n" +
             "      \"id\": 0,\n" +
             "      \"name\": \"string\"\n" +
             "    }\n" +
             "  ],\n" +
             "  \"status\": \"available\"\n" +
             "}").when().post("/pet");


        System.out.println(a.statusCode());

//
    }
}
