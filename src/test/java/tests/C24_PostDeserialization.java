package tests;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C24_PostDeserialization extends HerokuappBaseUrl {
    /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir
        POST request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
            Request body
                {
                "firstname" , "Ahmet"
                "lastname" , “Bulut"
                "totalprice" , 500
                "depositpaid" , false
                "bookingdates"  {
                                 "checkin" , "2021-06-01",
                                 "checkout" , "2021-06-10"
                                 },
                "additionalneeds" , "wi-fi"
                }

            Response Body // expected data
                {
                "bookingid",24
                "booking" {
                            "firstname","Ahmet"
                            "lastname","Bulut"
                            "totalprice",500
                            "depositpaid",false
                            "bookingdates" {
                                            "checkin","2021-06-01"
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
        HashMap<String,Object> reqBody = testDataHerokuapp.bookingMap();

        // 2- Expected Data hazirla
        HashMap<String,Object> expData = testDataHerokuapp.createExpectedBodyMap();

        // 3- Responce'i kaydet
        Response response = given().
                                    spec(specHerokuapp).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody).
                                    post("/{pp1}");

        // 4- Assertion
        HashMap<String, Object> resMap = response.as(HashMap.class);

        Assert.assertEquals(((Map)(expData.get("booking"))).get("firstname"),
                            ((Map)(resMap.get("booking"))).get("firstname"));

        Assert.assertEquals(((Map)(expData.get("booking"))).get("lastname"),
                            ((Map)(resMap.get("booking"))).get("lastname"));

        Assert.assertEquals(((Map)(expData.get("booking"))).get("totalprice"),
                            ((Map)(resMap.get("booking"))).get("totalprice"));

        Assert.assertEquals(((Map)(expData.get("booking"))).get("depositpaid"),
                            ((Map)(resMap.get("booking"))).get("depositpaid"));

        Assert.assertEquals(((Map)(expData.get("booking"))).get("additionalneeds"),
                            ((Map)(resMap.get("booking"))).get("additionalneeds"));

        Assert.assertEquals((((Map)(((Map)(expData.get("booking"))).get("bookingdates"))).get("checkin")),
                            (((Map)(((Map)(resMap.get("booking"))).get("bookingdates"))).get("checkin")));

        Assert.assertEquals((((Map)(((Map)(expData.get("booking"))).get("bookingdates"))).get("checkout")),
                            (((Map)(((Map)(resMap.get("booking"))).get("bookingdates"))).get("checkout")));
    }
}
