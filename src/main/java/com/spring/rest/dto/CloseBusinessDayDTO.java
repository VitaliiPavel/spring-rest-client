package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CloseBusinessDayDTO extends ResponseDTO{
    @JsonProperty("FLD_074")
    private String creditTransactionsCount;
    @JsonProperty("FLD_075")
    private String creditReversalsCount;
    @JsonProperty("FLD_076")
    private String debitTransactionsCount;
    @JsonProperty("FLD_077")
    private String debitReversalsCount;
    @JsonProperty("FLD_086")
    private String creditTransactionsTotalAmount;
    @JsonProperty("FLD_087")
    private String creditReversalsTotalAmount;
    @JsonProperty("FLD_088")
    private String debitTransactionsTotalAmount;
    @JsonProperty("FLD_089")
    private String debitReversalsTotalAmount;
}
