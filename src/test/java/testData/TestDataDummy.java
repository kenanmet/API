package testData;

import org.json.JSONObject;

public class TestDataDummy {

    public int statusCode=200;
    public String contentType="application/json";

    public JSONObject innerJSONBody (){

        JSONObject innerBody=new JSONObject();
        innerBody.put("id",3);
        innerBody.put("employee_name","Ashton Cox");
        innerBody.put("employee_salary",86000);
        innerBody.put("employee_age",66);
        innerBody.put("profile_image","");

        return innerBody;
    }

    public JSONObject createExpectedBodyJson (){

        JSONObject expBody=new JSONObject();
        expBody.put("status","success");
        expBody.put("data",innerJSONBody());
        expBody.put("message","Successfully! Record has been fetched.");

        return expBody;
    }

}
