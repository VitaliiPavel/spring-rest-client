package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    @JsonProperty("TRANSACTION_ID")
    private String transactionId;
    @JsonProperty("RESULT")
    private String result;
    @JsonProperty("RESULT_CODE")
    private String resultCode;
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
    @JsonProperty("error")
    private String error;
}
