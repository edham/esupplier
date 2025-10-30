
    package com.ebim.esupplier.web.dto;

    import lombok.Data;

    @Data
    public class BankAccountDTO {
        private String id;
private Integer businessPartnerId;
private String cuenta;
private String cci;
private String iban;
    }
