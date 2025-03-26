package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import entities.RequestBodyCreateNewProducts;
import entities.RequestBodyLombok;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Config;

public class CreateNewProducts {
    public static void main(String[] args) throws JsonProcessingException {
        String baseURL = Config.getProperty("url");
        String token = Config.getProperty("cashWiseToken");

        RequestBodyCreateNewProducts requestBodyCreateNewProducts = new RequestBodyCreateNewProducts();

        String product_title = "New product REst1";
        Integer product_price = 100;
        Integer service_type_id = 1;
        Integer category_id = 1953;   //Dairy
        String product_description = "TEST Description1";

        requestBodyCreateNewProducts.setProduct_title(product_title);
        requestBodyCreateNewProducts.setProduct_price(product_price);
        requestBodyCreateNewProducts.setService_type_id(service_type_id);
        requestBodyCreateNewProducts.setCategory_id(category_id);
        requestBodyCreateNewProducts.setProduct_description(product_description);

        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
                .body(requestBodyCreateNewProducts).post(baseURL + "/api/myaccount/products");
       /* System.out.println(requestBodyCreateNewProducts);
        System.out.println(response.statusCode());*/

        ObjectMapper mapper = new ObjectMapper();

        RequestBodyCreateNewProducts requestBodyCreateNewProducts1 = mapper.readValue(response.asString(), RequestBodyCreateNewProducts.class);
        System.out.println(requestBodyCreateNewProducts1.getProduct_description());
    }
}
