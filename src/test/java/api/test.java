package api;

import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.CashWiseToken;
import utilities.Config;
import utilities.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class test {


    @Test
    public void testToken() {
        String endPoint = "https://backend.cashwise.us/api/myaccount/auth/login";
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail((Config.getProperty("username1")));
        requestBody.setPassword((Config.getProperty("password2")));

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(requestBody).post(endPoint);
        int statusCode = response.statusCode();
        Assert.assertEquals(200, statusCode);

        String token = response.jsonPath().getString("jwt_token");    //Store JWT token Jsonpath and POJO
        System.out.println(token);
    }

    @Test
    public void GetSingleSeller() {
        String url = Config.getProperty("url") + "/api/myaccount/sellers/" + 5491;
        String token = CashWiseToken.GetToken();

        Response response = RestAssured.given().auth().oauth2(token).get(url);
        response.prettyPrint();
        System.out.println(response.jsonPath().getString("seller_id"));
        Assert.assertEquals(response.jsonPath().getString("company_name"), "Mraz Inc");
        System.out.println(response.jsonPath().getString("company_name"));

        String expectedEmail = response.jsonPath().getString("email");

        Assert.assertFalse(expectedEmail.isEmpty());
        Assert.assertTrue(expectedEmail.endsWith(".com"));
        //   Assert.assertTrue(expectedEmail.length() > 0);
        //       String ExpectedEmail = "Jonnycash@test.com";
        //       Assert.assertEquals(response.jsonPath().getString("email").equals(ExpectedEmail);


    }

    @Test
    public void GetAllSellersLoop() {
        String url = Config.getProperty("url") + "/api/myaccount/sellers";
        String token = CashWiseToken.GetToken();

        //Different values put in hashmap
        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("size", 10);
        params.put("page", 1);

        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);

        response.prettyPrint();

        String email1 = response.jsonPath().getString("responses[0].email");
        String email2 = response.jsonPath().getString("responses[1].email");
        System.out.println(email1);
        Assert.assertFalse(email1.isEmpty());
        Assert.assertFalse(email2.isEmpty());
    }
}



