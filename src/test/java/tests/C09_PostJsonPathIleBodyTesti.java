package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_PostJsonPathIleBodyTesti {
    /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
            {
            "firstname" : "Ahmet",
            "lastname" : "Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" :{
                            "checkin" : "2021-06-01",
                            "checkout" : "2021-06-10"
                            },
            "additionalneeds" : "wi-fi"
            }
        donen Response’un,
        - status code’unun 200,
        - ve content type’inin application-json,
        - ve response body’sindeki
            - "firstname"in,"Ahmet",
            - ve "lastname“in, "Bulut",
            - ve "totalprice“in,500,
            - ve "depositpaid“in,false,
            - ve "checkin" tarihinin 2021-06-01
            - ve "checkout" tarihinin 2021-06-10
            - ve "additionalneeds“in,"wi-fi"
        oldugunu test edin
     */

    @Test
    public void post01(){
        // 1- URL ve Body hazirla
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject innerObj=new JSONObject();
        innerObj.put("checkin" , "2021-06-01");
        innerObj.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" , innerObj);
        reqBody.put("additionalneeds" , "wi-fi");

        // 2- Expected Data hazirla

        // 3- Responce'i kaydet
        Response response = given().
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                                    post(url);

        // 4- Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("booking.firstname", equalTo("Ahmet"),
                        "booking.lastname",equalTo("Bulut"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10"),
                        "booking.additionalneeds",equalTo("wi-fi"));
    }
}
