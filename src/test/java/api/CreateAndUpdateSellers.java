package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.CashWiseToken;
import utilities.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateAndUpdateSellers {

    //Create 5 sellers
    @Test
    public void CreateSellers() {
        String url = Config.getProperty("url") + "/api/myaccount/sellers";
        String token = CashWiseToken.GetToken();

        RequestBody body = new RequestBody();
        Faker faker = new Faker();

        for (int i = 0; i < 5; i++) {
            body.setCompany_name(faker.company().name());
            body.setSeller_name(faker.harryPotter().character());
            body.setEmail(faker.internet().emailAddress());
            body.setPhone_number(faker.phoneNumber().cellPhone());
            body.setAddress(faker.address().streetAddress());

            Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(body).post(url);
            int statusCode = 201;
            Assert.assertEquals(response.statusCode(), statusCode);
            System.out.println(response.prettyPrint());
        }
    }

    @Test
    public void GetAllSellersIds() throws JsonProcessingException {
        String url = Config.getProperty("url") + "/api/myaccount/sellers";
        String token = CashWiseToken.GetToken();

        HashMap<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 10);

        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        List<Integer> sellerIds = new ArrayList<>();
        System.out.println(customResponse.getResponses().get(0).getSeller_id());

        for (int i = 0; i < customResponse.getResponses().size(); i++) {
            sellerIds.add(customResponse.getResponses().get(i).getSeller_id());
            System.out.println(customResponse.getResponses().get(i).getSeller_id());
            Assert.assertNotNull(customResponse.getResponses().get(i).getSeller_id());
        }
        Assert.assertTrue(sellerIds.size() >= 5);
        Assert.assertFalse(sellerIds.isEmpty());
    }

    //Update all records
    @Test
    public void GetCompaniesNameAndUpdate() throws JsonProcessingException {
        String url = Config.getProperty("url") + "/api/myaccount/sellers";
        String token = CashWiseToken.GetToken();

        HashMap<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 10);

        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);

        List<Integer> ids = new ArrayList<>();
        List<String> companyNames = new ArrayList<>();
        List<String> sellerNames = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        List<String> phoneNumbers = new ArrayList<>();
        List<String> addresses = new ArrayList<>();


        for (int i = 0; i < customResponse.getResponses().size(); i++) {
            ids.add(customResponse.getResponses().get(i).getSeller_id());
            companyNames.add(customResponse.getResponses().get(i).getCompany_name());
            sellerNames.add(customResponse.getResponses().get(i).getSeller_name());
            emails.add(customResponse.getResponses().get(i).getEmail());
            phoneNumbers.add(customResponse.getResponses().get(i).getPhone_number());
            addresses.add(customResponse.getResponses().get(i).getAddress());
        }

        RequestBody body = new RequestBody();
        String url2 = Config.getProperty("url") + "/api/myaccount/sellers/";
        Faker faker = new Faker();

        //Update
        for (int k = 0; companyNames.size() > k; k++) {
            body.setCompany_name(faker.company().name());
            body.setSeller_name(sellerNames.get(k));
            body.setPhone_number(phoneNumbers.get(k));
            body.setEmail(emails.get(k));
            body.setAddress(addresses.get(k));

            Response response2 = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
                    .body(body).put(url2 + ids.get(k));
            System.out.println(ids.get(k) + " : " + companyNames.get(k));

        }
        System.out.println();
        System.out.println("Update: " + companyNames.size() + " records");
    }

    //Update a single record
    @Test
    public void UpdateSingleCompanyEmail() {
        int id = 5492;
        String mail = "ufc@yahoo.com";
        String url = Config.getProperty("url") + "/api/myaccount/sellers/" + id;
        String token = CashWiseToken.GetToken();
        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name("SingleUpdateCompanyName");
        requestBody.setSeller_name("SingleUpdateSellerName");
        requestBody.setEmail(mail);
        requestBody.setPhone_number("123456789");
        requestBody.setAddress("FL");

        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).put(url);
        Assert.assertEquals(response.jsonPath().getString("email"), mail);
        Assert.assertTrue(response.jsonPath().getString("email").endsWith(".com"));
    }

    //Delete single record
    @Test
    public void DeleteCompanySeller() {
        String url = Config.getProperty("url") + "/api/myaccount/sellers/" + 5493;
        String token = CashWiseToken.GetToken();

        Response response = RestAssured.given().auth().oauth2(token).delete(url);
        System.out.println(response.statusCode());
    }

}
