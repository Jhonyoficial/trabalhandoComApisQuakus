package org.acme.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RegisterDataDTO {

    private String documentRecipient;

    private String documentPayer;

    private String payDueDate;

    private String dueDateRegister;

    private boolean allowChangeValue;

    private String recipient;

    private String payer;

    private BigDecimal discountValue;

    private BigDecimal interestValueCalculated;

    private BigDecimal maxValue;

    private BigDecimal minValue;

    private BigDecimal fineValueCalculated;

    private BigDecimal originalValue;

    private BigDecimal totalUpdated;

    private BigDecimal totalWithDiscount;

    private BigDecimal totalWithAdditional;
}
