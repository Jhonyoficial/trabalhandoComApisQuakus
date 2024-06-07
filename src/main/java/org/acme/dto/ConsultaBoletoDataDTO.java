package org.acme.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;

@Data
public class ConsultaBoletoDataDTO {

    @JsonbProperty("type")
    private Integer nmType;

    @JsonbProperty("digitable")
    private String dsDigitable;

    @JsonbProperty("value")
    private Double nmValue;
}
