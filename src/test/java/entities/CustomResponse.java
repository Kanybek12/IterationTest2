package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) //ignore list of properties
public class CustomResponse {

    private String id;
    private String name_tag;
    private String creation_date;

    private String company_name;

    private int product_price;
    private int seller_id;

    private String seller_name;
    private String email;
    private String phone_number;
    private String address;
    //Ids
    private List<CustomResponse> responses;





}
