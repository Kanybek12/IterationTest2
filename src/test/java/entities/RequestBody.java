package entities;


import lombok.Data;

@Data
public class RequestBody {

    private String name_tag;
    private String description;

   // private String email;
    private String password;

    //seller
    private String company_name;
    private String seller_name;
    private String email;
    private String phone_number;
    private String address;



    //Create a seller

}
