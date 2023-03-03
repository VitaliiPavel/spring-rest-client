package com.spring.rest.DTO;

public class ResponseDTO {
    private String transactionId;
    private String result;
    private String resultCode;
    private String error;
    private String numberOfCreditTransactions;
    private String numberOfCreditReversals;
    private String numberOfDebitTransactions;
    private String numberOfDebitReversals;
    private String totalAmountOfCreditTransactions;
    private String totalAmountOfCreditReversals;
    private String totalAmountOfDebitTransactions;
    private String totalAmountOfDebitReversals;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getNumberOfCreditTransactions() {
        return numberOfCreditTransactions;
    }

    public void setNumberOfCreditTransactions(String numberOfCreditTransactions) {
        this.numberOfCreditTransactions = numberOfCreditTransactions;
    }

    public String getNumberOfCreditReversals() {
        return numberOfCreditReversals;
    }

    public void setNumberOfCreditReversals(String numberOfCreditReversals) {
        this.numberOfCreditReversals = numberOfCreditReversals;
    }

    public String getNumberOfDebitTransactions() {
        return numberOfDebitTransactions;
    }

    public void setNumberOfDebitTransactions(String numberOfDebitTransactions) {
        this.numberOfDebitTransactions = numberOfDebitTransactions;
    }

    public String getNumberOfDebitReversals() {
        return numberOfDebitReversals;
    }

    public void setNumberOfDebitReversals(String numberOfDebitReversals) {
        this.numberOfDebitReversals = numberOfDebitReversals;
    }

    public String getTotalAmountOfCreditTransactions() {
        return totalAmountOfCreditTransactions;
    }

    public void setTotalAmountOfCreditTransactions(String totalAmountOfCreditTransactions) {
        this.totalAmountOfCreditTransactions = totalAmountOfCreditTransactions;
    }

    public String getTotalAmountOfCreditReversals() {
        return totalAmountOfCreditReversals;
    }

    public void setTotalAmountOfCreditReversals(String totalAmountOfCreditReversals) {
        this.totalAmountOfCreditReversals = totalAmountOfCreditReversals;
    }

    public String getTotalAmountOfDebitTransactions() {
        return totalAmountOfDebitTransactions;
    }

    public void setTotalAmountOfDebitTransactions(String totalAmountOfDebitTransactions) {
        this.totalAmountOfDebitTransactions = totalAmountOfDebitTransactions;
    }

    public String getTotalAmountOfDebitReversals() {
        return totalAmountOfDebitReversals;
    }

    public void setTotalAmountOfDebitReversals(String totalAmountOfDebitReversals) {
        this.totalAmountOfDebitReversals = totalAmountOfDebitReversals;
    }
}
