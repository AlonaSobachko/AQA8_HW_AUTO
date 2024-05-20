package lesson1.token;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class TryWithTokenClass {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://simple-books-api.glitch.me/";
        String randomMail = "mail" + new Random().nextInt(1000)
                + "mail" + new Random().nextInt(1000) + "@jdee.ewew";
        //System.out.println(randomMail);

        JSONObject registerBody = new JSONObject();
        registerBody.put("clientName", "Hakan");
        registerBody.put("clientEmail", randomMail);

        //реєстрація користувача
        Response response = given()
                .contentType(ContentType.JSON)
                .body(registerBody)
                .when()
                .post("api-clients/");
        //System.out.println(response.getBody().asString());
        String token = JsonParser.parseString(response.getBody().asString())
                .getAsJsonObject().get("accessToken").getAsString();
        System.out.println(token);

        JSONObject orderBody2 = new JSONObject();
        orderBody2.put("customerName", "Hakan");
        orderBody2.put("bookId", 4);

        JSONObject orderBody = new JSONObject();
        orderBody.put("customerName", "Hakan");
        orderBody.put("bookId", 1);


        //замовлення книги
        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(orderBody)
                .when()
                .post("orders");

        System.out.println(given().get("status").getBody().asString());

        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(orderBody2)
                .when()
                .post("orders");

        //отримати список замовлень
        System.out.println(given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(orderBody)
                .when()
                .get("orders").getBody().asString());

        JsonArray arrayOfOrders = JsonParser.parseString(given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(orderBody)
                .when()
                .get("orders").getBody().asString()).getAsJsonArray();
        System.out.println(arrayOfOrders.size());
        for (JsonElement order: arrayOfOrders){
            System.out.println(order.getAsJsonObject().get("id").getAsString());
        }
    }
}
