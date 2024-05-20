package lesson1.first_post_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class TryPostRequestHardJSONBody {
    public static JSONObject bodyForCreatePet(int petId, String petName) {
        JSONObject fullBody = new JSONObject();
        fullBody.put("id", petId);
        JSONObject category = new JSONObject();
        category.put("id", 10);
        category.put("name", "Worm");
        fullBody.put("category", category);
        fullBody.put("name", petName);
        JSONArray photoUrls = new JSONArray();
        photoUrls.add("url1");
        photoUrls.add("url2");
        fullBody.put("photoUrls", photoUrls);

        JSONObject tag1 = new JSONObject();
        tag1.put("id", 10);
        tag1.put("name", "tag1");

        JSONObject tag2 = new JSONObject();
        tag2.put("id", 20);
        tag2.put("name", "tag2");

        JSONArray tags = new JSONArray();
        tags.add(tag1);
        tags.add(tag2);

        fullBody.put("tags", tags);
        fullBody.put("status", "available");
        return fullBody;
    }
    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyForCreatePet(333, "Rain"))
                .when()
                .post("pet");
        System.out.println(response.getBody().asString());
    }
}
