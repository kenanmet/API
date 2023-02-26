package tests;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerokuappBooking;
import pojos.PojoHerokuappBookingdates;
import pojos.PojoHerokuappExpectedBody;

import static io.restassured.RestAssured.given;

public class C28_PostPojo extends HerokuappBaseUrl {
    /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
        gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
            Request body
                {
                "firstname" , "Ahmet"
                "lastname" , “Bulut"
                "totalprice" , 500
                "depositpaid" , false
                "bookingdates" {
                                "checkin" , "2021-06-01"
                                "checkout" , "2021-06-10"
                                }
                "additionalneeds" , "wi-fi"
                }

            Response Body // expected data
                {
                "bookingid":24,
                "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                            "checkin":"2021-06-01",
                                            "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                           }
                }
    */
    @Test
    public void post01(){
        // 1- URL ve body hazirla
        specHerokuapp.pathParam("pp1","booking");

        PojoHerokuappBookingdates bookingdates = new PojoHerokuappBookingdates("2021-06-01","2021-06-10");
        PojoHerokuappBooking reqBody = new PojoHerokuappBooking("Ahmet","Bulut",500,false,bookingdates,"wi-fi");

        // 2- Expected Data hazirla
        PojoHerokuappExpectedBody expData = new PojoHerokuappExpectedBody(24,reqBody);

        // 3- Responce'i kaydet
        Response response = given().
                                    spec(specHerokuapp).
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody).
                                    post("/{pp1}");

        // 4- Assertion
        PojoHerokuappExpectedBody respPojo = response.as(PojoHerokuappExpectedBody.class);

        Assert.assertEquals(expData.getBooking().getFirstname(),respPojo.getBooking().getFirstname());
        Assert.assertEquals(expData.getBooking().getLastname(),respPojo.getBooking().getLastname());
        Assert.assertEquals(expData.getBooking().getTotalprice(),respPojo.getBooking().getTotalprice());
        Assert.assertEquals(expData.getBooking().isDepositpaid(),respPojo.getBooking().isDepositpaid());
        Assert.assertEquals(expData.getBooking().getBookingdates().getCheckin(),respPojo.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expData.getBooking().getBookingdates().getCheckout(),respPojo.getBooking().getBookingdates().getCheckout());
        Assert.assertEquals(expData.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());
    }
}
