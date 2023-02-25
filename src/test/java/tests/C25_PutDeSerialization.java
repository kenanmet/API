package tests;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C25_PutDeSerialization extends JsonPlaceHolderBaseUrl {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
        yolladigimizda donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz
            Request Body / Expected Data
                {
                "title","Ahmet"
                "body","Merhaba"
                "userId",10
                "id",70
                }
    */
    @Test
    public void put01(){
        // 1- URL ve body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();
        HashMap<String,Object> reqBody = testDataJsonPlaceHolder.requestBodyOlusturMap();

        // 2- Expected Data hazirla
        HashMap<String,Object> expData = testDataJsonPlaceHolder.requestBodyOlusturMap();

        // 3- Responce'i kaydet
        Response response = given().
                                    spec(specJsonPlace).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody).
                                    put("/{pp1}/{pp2}");

        // 4- Assertion
        HashMap<String,Object>resMap = response.as(HashMap.class);

        Assert.assertEquals(expData.get("title"),resMap.get("title"));
        Assert.assertEquals(expData.get("body"),resMap.get("body"));
        Assert.assertEquals(expData.get("userId"),resMap.get("userId"));
        Assert.assertEquals(expData.get("id"),resMap.get("id"));
    }
}
