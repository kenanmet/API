package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_GetBodyTekrarlardanKurtulma {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
    donen Response’un,
 	- status code’unun 200,
	- ve content type’inin application-json,
	- ve response body’sindeki
	    - "firstname“in,"Mark",
        - ve "lastname“in, "Jackson",
        - ve "totalprice“in,981,
        - ve "depositpaid“in,false,
        - ve "additionalneeds“in,"Breakfast"
          oldugunu test edin
     */

    @Test
    public void get01(){
        // 1- URL hairla
        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected Data hazirla

        // 3- Responce'i kaydet
        Response response = given().when().get(url);

        // 4- Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname",equalTo("Mark"),
                "lastname", equalTo("Jackson"),
                "totalprice", equalTo(981),
                "depositpaid", equalTo(false),
                "additionalneeds", equalTo("Breakfast"));
    }
}
