package com.ebim.esupplier.web.dto;

import lombok.Data;
import java.time.Instant;

@Data
public class BusinessPartnerDTO {
    private Integer id;
    private String businessPartnerCode;
    private String name;
    private String taxId;
    private Boolean isActive;
    private String email;
    private String contactPerson;
    private String createdBy;
    private Instant lastModifiedAt;
    private String lastModifiedBy;
    private String sapBusinessPartnerId;
    private Integer homologationStatus;
    private Integer progressPercentage;
    private Instant submittedAt;
    private Instant reviewedAt;
    private Instant approvedAt;
    private String evaluatorComments;
    private String reviewedByUserId;
    private String userId; // Relación con User
    private Boolean acceptMarketing;
    private Boolean acceptTerms;
    private String address;
    private String businessPartnerType;
    private String categories; // Tipo String para arreglos PostgreSQL
    private String city;
    private String code;
    private String companyName;
    private String contactDepartment;
    private String contactEmail;
    private String contactFirstName;
    private String contactLastName;
    private String country;
    private String phone;
    private String postalCode;
}