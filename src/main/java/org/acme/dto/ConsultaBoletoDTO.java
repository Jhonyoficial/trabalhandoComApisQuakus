package org.acme.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;

@Data
public class ConsultaBoletoDTO {

    @JsonbProperty("barCode")
    private ConsultaBoletoDataDTO data;

    @JsonbProperty("billData")
    private ConsultaBoletoDataDTO bill;

    @JsonbProperty("transactionIdAuthorize")
    private Long nmIdTransacao;

    @JsonbProperty("cpfCnpj")
    private String dsCpfCnpj;

    @JsonbProperty("dueDate")
    private String dtDue;

}
