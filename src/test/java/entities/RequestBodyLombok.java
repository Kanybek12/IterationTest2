package entities;

import lombok.Data;

@Data
public class RequestBodyLombok {
    private String name_tag;
    private String description;

    private String email;
    private String password;

}
