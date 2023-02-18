package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_GetSoftAssertIleExpectedDataTesti {
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Response Body
                {
                "status","success",
                "data",{
                        "id",3,
                        "employee_name","Ashton Cox",
                        "employee_salary",86000,
                        "employee_age",66,
                        "profile_image",""
                        },
                "message","Successfully! Record has been fetched."
                }
     */
    @Test
    public void get01(){
        // 1- URL hazirla
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- Expected Data hazirla
        JSONObject innerBody=new JSONObject();
        innerBody.put("id",3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        JSONObject expectedBody=new JSONObject();
        expectedBody.put("status","success");
        expectedBody.put("data",innerBody);
        expectedBody.put("message","Successfully! Record has been fetched.");

        // 3- Responce'i kaydet
        Response response=given().when().get(url);

        // 4- Assertion
        JsonPath responceJPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responceJPath.get("status"),expectedBody.get("status"));
        softAssert.assertEquals(responceJPath.get("message"),expectedBody.get("message"));
        softAssert.assertEquals(responceJPath.get("data.id"),expectedBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(responceJPath.get("data.employee_name"),expectedBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responceJPath.get("data.employee_salary"),expectedBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responceJPath.get("data.employee_age"),expectedBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responceJPath.get("data.profile_image"),expectedBody.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();
    }
}

