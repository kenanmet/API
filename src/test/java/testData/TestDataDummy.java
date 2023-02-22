package testData;

import org.json.JSONObject;

import java.util.HashMap;

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

    public HashMap createInnerBodyMap (){

        HashMap<String,Object> innerBodyMap=new HashMap<>();
        innerBodyMap.put("id",3.0);
        innerBodyMap.put("employee_name","Ashton Cox");
        innerBodyMap.put("employee_salary",86000.0);
        innerBodyMap.put("employee_age",66.0);
        innerBodyMap.put("profile_image","");

        return innerBodyMap;
    }
    public HashMap createExpectedBodyMap (){

        HashMap<String,Object> responseBodyMap=new HashMap<>();
        responseBodyMap.put("status","success");
        responseBodyMap.put("message","Successfully! Record has been fetched.");
        responseBodyMap.put("data",createInnerBodyMap());

        return responseBodyMap;
    }

}
