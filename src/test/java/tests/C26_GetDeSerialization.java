package tests;

import baseURL.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C26_GetDeSerialization extends DummyBaseUrl {
    /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
            Response Body
                {
                "status","success",
                "data" {
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
        specDummy.pathParams("pp1","employee","pp2",3);

        // 2- Expected Data hazirla
        TestDataDummy testDataDummy = new TestDataDummy();
        HashMap<String,Object> expData = testDataDummy.createExpectedBodyMap();

        // 3- Responce'i kaydet
        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}");

        // 4- Assertion
        HashMap<String,Object> resMap = response.as(HashMap.class);

        Assert.assertEquals(expData.get("status"),resMap.get("status"));
        Assert.assertEquals(expData.get("message"),resMap.get("message"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("id"),((Map)(resMap.get("data"))).get("id"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_name"),((Map)(resMap.get("data"))).get("employee_name"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_salary"),((Map)(resMap.get("data"))).get("employee_salary"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("employee_age"),((Map)(resMap.get("data"))).get("employee_age"));
        Assert.assertEquals(((Map)(expData.get("data"))).get("profile_image"),((Map)(resMap.get("data"))).get("profile_image"));
    }
}
