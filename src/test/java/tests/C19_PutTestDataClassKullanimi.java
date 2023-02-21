package tests;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_PutTestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
        body’e sahip bir PUT request yolladigimizda donen response’in
        status kodunun 200, content type’inin "application/json; charset=utf-8",
        Connection header degerinin "keep-alive"
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
            Request Body
                {
                    "title","Ahmet",
                    "body","Merhaba",
                    "userId",10,
                    "id",70
                }

            Expected Data :
                {
                    "title","Ahmet",
                    "body","Merhaba",
                    "userId",10,
                    "id",70
                }
    */

    @Test
    public void put01(){
        // 1- URL ve Body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        JSONObject reqBody = testDataJsonPlaceHolder.createRequestBodyJSON();

        // 2- Expected Data hazirla
        JSONObject expData = testDataJsonPlaceHolder.createRequestBodyJSON();

        // 3- Responce'i kaydet
        Response response = given().
                                    spec(specJsonPlace).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                                    put("/{pp1}/{pp2}");

        // 4- Assertion
        JsonPath resJP = response.jsonPath();

        assertEquals(testDataJsonPlaceHolder.successfulStatusCode,response.getStatusCode());
        assertEquals(testDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(testDataJsonPlaceHolder.connectionHeader,response.getHeader("Connection"));
        assertEquals(expData.get("title"),resJP.get("title"));
        assertEquals(expData.get("body"),resJP.get("body"));
        assertEquals(expData.get("userId"),resJP.get("userId"));
        assertEquals(expData.get("id"),resJP.get("id"));
    }
}
