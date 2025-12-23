package Assertions;

import io.restassured.response.Response;
import org.testng.Assert;


public class verify {
/*
This code is basically for the veridication iof the sttaus code
 */


    public void verifystatuscode(Response a, int status) {

        Assert.assertEquals(a.getStatusCode(), status);
    }


    /*
    This code is basically for the verify the pet which is created
     */

    public static void verifyPetCreated(Response response,
                                        String expectedName,
                                        String expectedStatus) {

        Assert.assertNotNull(
                response.jsonPath().get("id"),
                "Pet ID is null"
        );

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                expectedName,
                "Pet name mismatch"
        );

        Assert.assertEquals(
                response.jsonPath().getString("status"),
                expectedStatus,
                "Pet status mismatch"
        );
    }


}



