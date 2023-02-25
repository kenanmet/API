package tests;

import baseURL.HerokuappBaseUrl;
import org.junit.Test;

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

        // 2- Expected Data hazirla
        // 3- Responce'i kaydet
        // 4- Assertion
    }
}
