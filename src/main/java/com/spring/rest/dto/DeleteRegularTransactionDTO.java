package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteRegularTransactionDTO {
    @JsonProperty("RESULT")
    private String result;
}
