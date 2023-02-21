package testData;

import org.json.JSONObject;

public class TestDataHerokuapp {

    public JSONObject innerBookingdatesJSBody (){

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        return bookingdates;
    }

    public JSONObject innerBookingJSBody (){

        JSONObject booking=new JSONObject();
        booking.put("firstname","Ahmet");
        booking.put("lastname","Bulut");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);
        booking.put("bookingdates",innerBookingdatesJSBody());
        booking.put("additionalneeds","wi-fi");

        return booking;
    }

    public JSONObject createExpectedBodyJson (){

        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",innerBookingJSBody());

        return expBody;
    }
}
