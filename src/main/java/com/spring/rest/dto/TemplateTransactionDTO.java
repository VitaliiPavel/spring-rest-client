package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateTransactionDTO extends ResponseDTO{
    @JsonProperty("RRN")
    private String referenceRetrievalNumber;
    @JsonProperty("APPROVAL_CODE")
    private String approvalCode;
}
