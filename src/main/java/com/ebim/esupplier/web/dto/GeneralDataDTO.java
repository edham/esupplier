package com.ebim.esupplier.web.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class GeneralDataDTO {
    private Integer id;
    private Integer businessPartnerId;
    private String ruc;
    private String email;
    private String companyName;
    private String ciiu;
    private String taxId;
    private String address;
    private String website;
    private String regionId;
    private String countryId;
    private String categories; // Tipo String para arreglos PostgreSQL
    private Integer currencies;
    private String districtId;
    private String postalCode;
    private String provinceId;
    private String sunatEmail;
    private Boolean sunatActive;
    private Boolean sunatHabido;
    private String businessName;
    private String businessType;
    private String voucherTypes; // Tipo String para arreglos PostgreSQL
    private String fiscalAddress;
    private String commercialName;
    private Integer supplierTypeId;
    private String taxpayerTypeId;
    private String businessSectors; // Tipo String para arreglos PostgreSQL
    private String detractionEmail;
    private LocalDate inscriptionDate;
    private Integer yearsInOperation;
    private LocalDate establishmentDate;
    private String territorialRegion;
    private Integer paymentConditionId;
}