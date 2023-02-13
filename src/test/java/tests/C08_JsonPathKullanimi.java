package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JsonPathKullanimi {
    @Test
    public void test01(){
        JSONObject kisiBilgileri = new JSONObject();
        JSONObject adresBilgileri = new JSONObject();
        JSONObject cepTelefonu = new JSONObject();
        JSONObject evTelefonu = new JSONObject();
        JSONArray telefonBilgileri = new JSONArray();

        cepTelefonu.put("type","Cep Telefonu");
        cepTelefonu.put("number", "555-123-4567");

        evTelefonu.put("type","Ev telefonu");
        evTelefonu.put("number","312-123-4567");

        telefonBilgileri.put(evTelefonu);
        telefonBilgileri.put(cepTelefonu);

        adresBilgileri.put("streetAddress", "Yenimahalle kurtulus cad");
        adresBilgileri.put("city","Ankara");
        adresBilgileri.put("postalCode","06100");

        kisiBilgileri.put("firstName","Ahmet");
        kisiBilgileri.put("lastName","Bulut");
        kisiBilgileri.put("age",49);
        kisiBilgileri.put("adres",adresBilgileri);
        kisiBilgileri.put("telefonNumaralari",telefonBilgileri);

        System.out.println(kisiBilgileri);

    }
}
