package tests;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C16_BaseUrlHerokuapp extends HerokuappBaseUrl {
    // Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

    @Test
    public void get01(){
        /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir
            GET request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve Response’ta 12 id'sine sahip bir booking oldugunu test edin.
        */

        // 1- URL hazirla
        specHerokuapp.pathParam("pp1","booking");

        // 2- Expected Data hazirla
        // 3- Responce'i kaydet
        Response response = given().
                                    spec(specHerokuapp).
                            when().
                                    get("/{pp1}");

        // 4- Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid", hasItem(12));
    }

    @Test
    public void post01(){
        /*
        2- https://restful-booker.herokuapp.com/booking endpointine asagidaki body’ye sahip
           bir POST request gonderdigimizde donen response’un status code’unun 200 oldugunu
           ve "firstname" degerinin "Ahmet" oldugunu test edin
                 {
                 "firstname" , "Ahmet",
                 "lastname" , "Bulut",
                 "totalprice" , 500,
                 "depositpaid" , false,
                 "bookingdates" , {
                                   "checkin" , "2021-06-01",
                                   "checkout" , "2021-06-10"
                                   },
                 "additionalneeds" , "wi-fi"
                 }
        */

        // 1- URL ve body hazirla
        specHerokuapp.pathParam("pp1","booking");

        JSONObject innerBody=new JSONObject();
        JSONObject reqBody=new JSONObject();

        innerBody.put("checkin" , "2021-06-01");
        innerBody.put("checkout" , "2021-06-10");

        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" , innerBody);
        reqBody.put("additionalneeds" , "wi-fi");

        // 2- Expected Data hazirla
        // 3- Responce'i kaydet
        Response response = given().
                                    spec(specHerokuapp).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                                    post("/{pp1}");

        // 4- Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("booking.firstname",equalTo("Ahmet"));
    }
}
