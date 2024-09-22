package api.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Objects {
    public static Response response;
    static String base_url = BasePage.getURL().getString("url");

    public static Response postObject(String newObject){

        response =  given()
                .contentType("application/json")
                .baseUri(base_url)
                .body(newObject)
                .when()
                .post("/objects")
                .then().log().all().extract().response();
        return response;
    }
    public static Response deleteObject(String objectId) {

        return given()
                .baseUri(base_url)
                .when()
                .delete("/objects/" + objectId).then().log().all().extract().response();

    }
}
