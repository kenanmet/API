package testData;

import org.json.JSONObject;

public class TestDataJsonPlaceHolder {

    public int successfulStatusCode=200;
    public String contentType = "application/json; charset=utf-8";
    public String connectionHeader="keep-alive";

    public JSONObject createExpectedBodyJSON (){

        JSONObject expBodyJson=new JSONObject();
        expBodyJson.put("userId",3);
        expBodyJson.put("id",22);
        expBodyJson.put("title","dolor sint quo a velit explicabo quia nam");
        expBodyJson.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum " +
                "mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expBodyJson;
    }

    public JSONObject createRequestBodyJSON (){

        JSONObject reqBodyJson=new JSONObject();
        reqBodyJson.put("userId",10);
        reqBodyJson.put("id",70);
        reqBodyJson.put("title","Ahmet");
        reqBodyJson.put("body","Merhaba");

        return reqBodyJson;
    }

}
