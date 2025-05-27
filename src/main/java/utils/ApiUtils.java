package utils;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiUtils {
	public static Response sendPost(String endpoint, Object body) {
        return given()
                .baseUri(ConfigReader.getProperty("baseURI"))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response sendPut(String endpoint, Object body) {
        return given()
                .baseUri(ConfigReader.getProperty("baseURI"))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(endpoint);
    }

    public static Response sendGet(String endpoint) {
        return given()
                .baseUri(ConfigReader.getProperty("baseURI"))
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint);
    }

    public static Response sendDelete(String endpoint) {
        return given()
                .baseUri(ConfigReader.getProperty("baseURI"))
                .contentType(ContentType.JSON)
                .when()
                .delete(endpoint);
    }
}
