
    package com.ebim.esupplier.web.dto;

    import lombok.Data;

    @Data
    public class BusinessPartnerDTO {
        private Integer id;
private String businessPartnerCode;
private String name;
private String taxId;
private Boolean isActive;
private String email;
    }
