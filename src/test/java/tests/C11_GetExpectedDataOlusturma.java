package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_GetExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Response body :
        {
        "userId":3,
        "id":22,
        "title":"dolor sint quo a velit explicabo quia nam",
        "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
             um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */

    @Test
    public void get01(){
        // 1- URL hazirla
        String url="https://jsonplaceholder.typicode.com/posts/22";

        // 2- Expected Data hazirla
        JSONObject expectedBody=new JSONObject();
        expectedBody.put("userId",3);
        expectedBody.put("id",22);
        expectedBody.put("title","dolor sint quo a velit explicabo quia nam");
        expectedBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita " +
                "earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        // 3- Responce'i kaydet
        Response response=given().when().get(url);

        // 4- Assertion
        JsonPath resJsonPath = response.jsonPath();

        Assert.assertEquals(expectedBody.get("userId"),resJsonPath.getInt("userId"));
        Assert.assertEquals(expectedBody.get("id"),resJsonPath.getInt("id"));
        Assert.assertEquals(expectedBody.get("title"),resJsonPath.getString("title"));
        Assert.assertEquals(expectedBody.get("body"),resJsonPath.getString("body"));
    }
}
