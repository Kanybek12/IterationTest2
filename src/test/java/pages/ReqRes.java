/*
import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.util.Asserts;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class ReqRes {
    public static void main(String[] args) {
        String URL = "https://backend.cashwise.us";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MjU3NTYyNTQsImlhdCI6MTcyMzE2NDI1NCwidXNlcm5hbWUiOiJrYW55YmVrLmt5cmd5enN0YW5AZ21haWwuY29tIn0.ONodnQZ6bpXlsFiVYskJDmlToIxoOtbUSiGAmpoN_l0d8jCJ-NcQlxTZLpvm_L1dRF3V-5rrZNjMYsB1BqezYw";
        String client = "Lawson";
        RequestSpecification httpRequest = RestAssured
                .given()
                .auth()
                .oauth2(token);
       // String data = {"name":"sd"}
//        Response response = RestAssured.get(URL);
//        System.out.println(response.prettyPrint());
//        System.out.println(response.statusCode());
//
//        String firstName = response.jsonPath().get("data.first_name");
//        String lastName = response.jsonPath().get("data.last_name");
//        String text = response.jsonPath().get("data.text");
//
//        System.out.println(firstName);
//        System.out.println(lastName);
//        System.out.println(text);

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 2);
        Response response = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .params(params)
                .get(URL + "/api/myaccount/sellers");
  */
/*      System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());*//*


        String sellerId = response.jsonPath().get("responses.seller_id[0]").toString();
        String sellerName = response.jsonPath().get("responses.seller_name").toString();
        String sellerEmail = response.jsonPath().get("responses.email").toString();
        String phone_number = response.jsonPath().get("responses.phone_number").toString();
        System.out.println(sellerId);
        System.out.println(sellerName);
        System.out.println(sellerEmail);
        System.out.println(phone_number);



        String replacementDetails = "{\r\n" +
                "  \"userId\": \"a178a104-e3c0-4f50-bbd5-3e4919f063e8\",\r\n" +
                "  \"isbn\": \"9781449331818\"\r\n" +
                "}";

        Response replaceBooksResponse = request.body(replacementDetails).put("BookStore/v1/Books/9781449325862");

        Assertions.assertEquals(200, replaceBooksResponse.getStatusCode());

        replaceBooksResponse.prettyPrint();

   */
/*     Response response1 = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .params(params)
                .put(URL + "/api/myaccount/sellers");

        String sellerIdPut = response1.jsonPath().put("responses.seller_id[0]").toString();
        String sellerNamePut = response.jsonPath().get("responses.seller_name").toString();
        String sellerEmailPut = response.jsonPath().get("responses.email").toString();
        String phone_numberPut = response.jsonPath().get("responses.phone_number").toString();
*//*



   */
/*     Response response1 = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .params(params)
                .get(URL + "/api/myaccount/sellers");

        System.out.println(response1.jsonPath().get("response1.*").toString());*//*

 */
/*       String sellerName1 = response.jsonPath().get("data.first_name").toString();
        System.out.println(sellerName);*//*


       */
/* String actualSellerId = response1.jsonPath().get("seller_id").toString();
        Assert.assertEquals(sellerId, actualSellerId);*//*


    }

}
*/
