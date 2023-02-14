package tests;

import org.junit.Test;

public class C12_PostExpectedDataVeJsonPathIleAssertion {
    /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                              },
            "additionalneeds" : "wi-fi"
        }

        Response Body
        {
            "bookingid":24,
            "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                                        "checkin":"2021-06-01",
                                        },
                        "additionalneeds":"wi-fi"
                        }
        }
    */

    @Test
    public void post01(){
        // 1- URL ve Body hazirla
        String url="https://restful-booker.herokuapp.com/booking";

        // 2- Expected Data hazirla
        // 3- Responce'i kaydet
        // 4- Assertion
    }
}
