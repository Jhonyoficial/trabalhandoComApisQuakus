package org.acme.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;

@Data
public class TokenDTO {

    @JsonbProperty("access_token")
    private String accessToken;

    @JsonbProperty("expires_in")
    private String expiresIn;
}
