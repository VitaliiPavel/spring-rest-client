package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.rest.enums.PaymentServerResultStatuses;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TransactionStatusDTO extends ResponseDTO {
    @JsonProperty("RESULT_PS")
    private PaymentServerResultStatuses resultPs;
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
