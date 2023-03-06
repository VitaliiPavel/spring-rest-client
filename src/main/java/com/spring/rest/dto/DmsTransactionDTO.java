package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DmsTransactionDTO extends ResponseDTO{
    @JsonProperty("RRN")
    private String referenceRetrievalNumber;
    @JsonProperty("APPROVAL_CODE")
    private String approvalCode;
    @JsonProperty("CARD_NUMBER")
    private String cardNumber;
}
