package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequestStatusTransactionDTO extends ResponseDTO {
//    @JsonProperty("RESULT")
//    private String result;
//    @JsonProperty("RESULT_CODE")
//    private String resultCode;
    @JsonProperty("RESULT_PS")
    private String resultPs;
    @JsonProperty("3DSECURE")
    private String secureStatus;
    @JsonProperty("3DSECURE_REASON")
    private String secureReason;
    @JsonProperty("RRN")
    private String referenceRetrievalNumber;
    @JsonProperty("APPROVAL_CODE")
    private String approvalCode;
    @JsonProperty("CARD_NUMBER")
    private String cardNumber;
    @JsonProperty("AAV")
    private String aav;
    @JsonProperty("PAYMENT_ACCOUNT_REFERENCE")
    private String paymentAccountReference;
    @JsonProperty("RECC_PMNT_ID")
    private String recurringPaymentId;
    @JsonProperty("RECC_PMNT_EXPIRY")
    private String recurringPaymentExpireDate;
    @JsonProperty("MRCH_TRANSACTION_ID")
    private String merchantTransactionId;
}
