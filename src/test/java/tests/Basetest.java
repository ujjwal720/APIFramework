package tests;

import endpoints.apipoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public class Basetest {

    public RequestSpecification specification;

    /*
    The following method will run before any test, this method will
    basically concat with all the requests which we will us in our tests
     */

     @BeforeClass
    public void initsetup(){
         System.out.println("Parent before class");
         specification=given().baseUri(apipoints.BASE_URL).contentType("application/json");


     }


     public Response getRequest(String endpoint){

         return given().spec(specification).when().get(endpoint);
     }

     public Response post(String endpoint, String body){

         return given().spec(specification).body(body).when().post(endpoint);

     }

     /*

      */

     public int getStatusCode(Response response){

         return response.getStatusCode();

     }

     public Response put(String endpoint, String body){

         return given().spec(specification).body(body).when().put(endpoint);

     }

     public RequestSpecification addtoken(String token){

         return given().spec(specification).auth().oauth2(token);
     }

     public RequestSpecification addqueryparam(String key, Object value){

         return given().spec(specification).queryParam(key,value);
     }














}
