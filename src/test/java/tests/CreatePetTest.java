package tests;
import Assertions.verify;
import Payload.Request.Payloads;
import endpoints.apipoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Objects;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;



public class CreatePetTest extends Basetest {


    public apipoints endpoints;
    public Payloads payload;
    int expectedstatus_code;
    public verify verfication;


    @BeforeClass
    public void setup(){

        endpoints=new apipoints();
        payload=new Payloads();
        expectedstatus_code=200;
        verfication=new verify();
    }

    /*
    The following is an post request for the creation of the pet
     */

    @Test(description = "To test whether the user is able to create an post request ")
    public void createpet(){

        String data=Payloads.createPetPayload(1,0,"Available",
                "Ramesh","photo.jpeg",1,"Pkemon","available");
        Response create_req=post(apipoints.POST_req,data);
        int sttaus_code= getStatusCode(create_req);
        verfication.verifystatuscode(create_req,expectedstatus_code);
    }

    public void updatepet(){}













}
