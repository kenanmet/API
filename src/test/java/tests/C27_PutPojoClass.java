package tests;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C27_PutPojoClass extends JsonPlaceHolderBaseUrl {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
        yolladigimizda donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz
            Request Body / Expected Data
                {
                "title","Ahmet",
                "body","Merhaba",
                "userId",10,
                "id",70
                }
    */

    @Test
    public void put01(){
        // 1- URL ve body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        PojoJsonPlaceHolder reqBody = new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        // 2- Expected Data hazirla
        PojoJsonPlaceHolder expData = new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        // 3- Responce'i kaydet
        Response response = given().
                                    spec(specJsonPlace).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody).
                                    put("/{pp1}/{pp2}");

        // 4- Assertion
        PojoJsonPlaceHolder respPojo = response.as(PojoJsonPlaceHolder.class);

        Assert.assertEquals(expData.getTitle(),respPojo.getTitle());
        Assert.assertEquals(expData.getBody(),respPojo.getBody());
        Assert.assertEquals(expData.getUserId(),respPojo.getUserId());
        Assert.assertEquals(expData.getId(),respPojo.getId());
    }
}
