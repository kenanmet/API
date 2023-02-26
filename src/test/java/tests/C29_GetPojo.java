package tests;

import baseURL.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyDate;
import pojos.PojoDummyExpectedBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_GetPojo extends DummyBaseUrl {
    /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
        donen response’un asagidaki gibi oldugunu test edin.
            Response Body
                {
                "status":"success",
                "data":{
                        "id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."
                }
    */
    @Test
    public void get01(){
        // 1- URL hazirla
        specDummy.pathParams("pp1","employee","pp2",3);

        // 2- Expected Data hazirla
        PojoDummyDate date = new PojoDummyDate(3,"Ashton Cox",86000,66,"");
        PojoDummyExpectedBody expData = new PojoDummyExpectedBody("success",date,"Successfully! Record has been fetched.");

        // 3- Responce'i kaydet
        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}");

        // 4- Assertion
        PojoDummyExpectedBody respPojo = response.as(PojoDummyExpectedBody.class);

        assertEquals(expData.getStatus(),respPojo.getStatus());
        assertEquals(expData.getData().getId(),respPojo.getData().getId());
        assertEquals(expData.getData().getEmployee_name(),respPojo.getData().getEmployee_name());
        assertEquals(expData.getData().getEmployee_salary(),respPojo.getData().getEmployee_salary());
        assertEquals(expData.getData().getEmployee_age(),respPojo.getData().getEmployee_age());
        assertEquals(expData.getData().getProfile_image(),respPojo.getData().getProfile_image());
        assertEquals(expData.getMessage(),respPojo.getMessage());
    }
}
