package tests;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuapp;

import static io.restassured.RestAssured.given;

public class C21_PostTestDataKullanimi extends HerokuappBaseUrl {
    /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir
        POST request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
            Request body
                {
                 "firstname" , "Ahmet",
                 "lastname" , “Bulut",
                 "totalprice" , 500,
                 "depositpaid" , false,
                 "bookingdates" , {
                                   "checkin" , "2021-06-01",
                                   "checkout" , "2021-06-10"
                                   },
                 "additionalneeds" , "wi-fi"
                }

            Response Body
                {
                "bookingid",24,
                "booking",{
                           "firstname","Ahmet",
                           "lastname","Bulut",
                           "totalprice",500,
                           "depositpaid",false,
                           "bookingdates",{
                                           "checkin","2021-06-01",
                                           "checkout","2021-06-10"
                                           },
                           "additionalneeds","wi-fi"
                           }
                }
    */

    @Test
    public void post01(){
        // 1- URL ve body hazirla
        specHerokuapp.pathParam("pp1","booking");

        TestDataHerokuapp testDataHerokuapp = new TestDataHerokuapp();
        JSONObject reqBody = testDataHerokuapp.innerBookingJSBody();

        // 2- Expected Data hazirla
        JSONObject expData = testDataHerokuapp.createExpectedBodyJson();

        // 3- Responce'i kaydet
        Response response = given().
                                    spec(specHerokuapp).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                                    post("/{pp1}");

        // 4- Assertion
        JsonPath resJP=response.jsonPath();

        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        Assert.assertEquals(expData.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));
        Assert.assertEquals(expData.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
    }
}
