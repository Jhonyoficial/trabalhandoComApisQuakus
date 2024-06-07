package org.acme.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConsultaResponseDTO {
    private String assignor;

    private String settleDate;

    private String dueDate;

    private String endHour;

    private String initeHour;

    private String nextSettle;

    private String digitable;

    private BigDecimal transactionId;

    private BigDecimal type;

    private BigDecimal value;

    private String errorCode;

    private String message;

    private BigDecimal status;

    private RegisterDataDTO registerData;
}
