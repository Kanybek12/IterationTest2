package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import entities.RequestBody;
import entities.RequestBodyLombok;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Config;

public class IntroToSerialization {

    public static void main(String[] args) throws JsonProcessingException {

        String baseURL = Config.getProperty("url");
        String token = Config.getProperty("cashWiseToken");

        RequestBodyLombok body = new RequestBodyLombok();
        String nameTag = "Xtrim2";
        String description = "Data CashWise2";
        body.setName_tag(nameTag);
        body.setDescription(description);
        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
                .body(body).post(baseURL + "/api/myaccount/tags");
        System.out.println(body);
        System.out.println(response.statusCode());

        ObjectMapper mapper = new ObjectMapper();

        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(customResponse.getId());

        //task

    }
}
