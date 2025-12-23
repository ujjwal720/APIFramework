package Utility;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class ResponseUtil {

    // Get full response body as String
    public static String getBodyAsString(Response response) {
        return response.getBody().asString();
    }

    // Get JsonPath object
    public static JsonPath getJsonPath(Response response) {
        return response.jsonPath();
    }

    // Get String value from response
    public static String getString(Response response, String path) {
        return response.jsonPath().getString(path);
    }

    // Get Integer value from response
    public static int getInt(Response response, String path) {
        return response.jsonPath().getInt(path);
    }

    // Get Boolean value
    public static boolean getBoolean(Response response, String path) {
        return response.jsonPath().getBoolean(path);
    }

    // Get List from response
    public static List<?> getList(Response response, String path) {
        return response.jsonPath().getList(path);
    }

    // Get response status code
    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }
}

