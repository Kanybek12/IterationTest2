package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBodyCreateNewProducts {

    public String product_title;
    public Integer product_price;
    public Integer service_type_id;
    public Integer category_id;
    public String product_description;

}
