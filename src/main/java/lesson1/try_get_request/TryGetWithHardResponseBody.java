package lesson1.try_get_request;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class TryGetWithHardResponseBody {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";

        Response response = RestAssured.get("/api/users?page=2");

        //получаем тело в виде строки
        String responseString = response.getBody().asString();
        System.out.println(responseString);

        //получаем тело в виде JsonObject
        JsonObject jsonObjectResponse = JsonParser.parseString(responseString).getAsJsonObject();

        //Получение значения по ключу
        int total = jsonObjectResponse.get("total").getAsInt();
        System.out.println("Total amount of users is " + total);

        //Забираем data
        JsonArray arrayOfUsers = jsonObjectResponse.getAsJsonArray("data").getAsJsonArray();
        System.out.println(arrayOfUsers.size());

        for (JsonElement user: arrayOfUsers){
            System.out.println("=====================");
            System.out.println(user.getAsJsonObject().get("id").getAsInt());
            System.out.println(user.getAsJsonObject().get("email").getAsString());
            System.out.println(user.getAsJsonObject().get("first_name").getAsString());
        }
    }
}
