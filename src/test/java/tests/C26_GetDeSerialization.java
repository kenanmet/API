package tests;

import org.junit.Test;

public class C26_GetDeSerialization {
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
        // 1- URL ve body hazirla
        // 2- Expected Data hazirla
        // 3- Responce'i kaydet
        // 4- Assertion
    }
}
