package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CloseDayDTO extends RegisterTransactionDTO{
    @JsonProperty("RESULT")
    private String result;
    @JsonProperty("RESULT_CODE")
    private String resultCode;
    @JsonProperty("FLD_074")
    private String creditTransactionsNumber;
    @JsonProperty("FLD_075")
    private String creditReversalsNumber;
    @JsonProperty("FLD_076")
    private String debitTransactionsNumber;
    @JsonProperty("FLD_077")
    private String debitReversalsNumber;
    @JsonProperty("FLD_086")
    private String creditTransactionsTotalAmount;
    @JsonProperty("FLD_087")
    private String creditReversalsTotalAmount;
    @JsonProperty("FLD_088")
    private String debitTransactionsTotalAmount;
    @JsonProperty("FLD_089")
    private String debitReversalsTotalAmount;
}
