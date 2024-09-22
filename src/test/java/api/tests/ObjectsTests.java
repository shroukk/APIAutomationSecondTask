package api.tests;

import api.endpoints.Objects;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectsTests {
    private Response response;
    private String objectId;

    @Test(priority = 1)
    public void userAddsANewObject() throws IOException {
        String requestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/data.json")));


        response = Objects.postObject(requestBody);

        objectId = response.jsonPath().getString("id"); // Get the ID from the response
    }

    @Test(priority = 2)
    public void theResponseCodeShouldBeForAddingObject() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test(priority = 3)
    public void userDeletesTheCreatedObject() {
        Response deleteResponse = Objects.deleteObject(objectId);
        Assert.assertEquals(200, deleteResponse.getStatusCode());

        String message = deleteResponse.jsonPath().getString("message");
        Assert.assertTrue(message.contains("Object with id = " + objectId + " has been deleted."));
    }
}
