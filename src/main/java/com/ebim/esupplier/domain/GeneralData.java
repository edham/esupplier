package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "general_data", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class GeneralData extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id", nullable = false)
    private BusinessPartner businessPartner;

    @Column(name = "ruc", nullable = false)
    private String ruc;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "ciiu")
    private String ciiu;

    @Column(name = "tax_id")
    private String taxId;

    @Column(name = "address")
    private String address;

    @Column(name = "website")
    private String website;

    @Column(name = "region_id")
    private String regionId;

    @Column(name = "country_id")
    private String countryId;

    @Column(name = "categories")
    private String categories; // Mapeado como String para tipos de arreglo de PostgreSQL (_int4)

    @Column(name = "currencies")
    private Integer currencies;

    @Column(name = "district_id")
    private String districtId;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "province_id")
    private String provinceId;

    @Column(name = "sunat_email")
    private String sunatEmail;

    @Column(name = "sunat_active")
    @Builder.Default
    private Boolean sunatActive = false;

    @Column(name = "sunat_habido")
    @Builder.Default
    private Boolean sunatHabido = false;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "business_type")
    private String businessType;

    @Column(name = "voucher_types")
    private String voucherTypes; // Mapeado como String para tipos de arreglo de PostgreSQL (_int4)

    @Column(name = "fiscal_address")
    private String fiscalAddress;

    @Column(name = "commercial_name")
    private String commercialName;

    @Column(name = "supplier_type_id")
    private Integer supplierTypeId;

    @Column(name = "taxpayer_type_id")
    private String taxpayerTypeId;

    @Column(name = "business_sectors")
    private String businessSectors; // Mapeado como String para tipos de arreglo de PostgreSQL (_int4)

    @Column(name = "detraction_email")
    private String detractionEmail;

    @Column(name = "inscription_date")
    private LocalDate inscriptionDate;

    @Column(name = "years_in_operation")
    private Integer yearsInOperation;

    @Column(name = "establishment_date")
    private LocalDate establishmentDate;

    @Column(name = "territorial_region")
    private String territorialRegion;

    @Column(name = "payment_condition_id")
    private Integer paymentConditionId;

    @Override
    public Integer getId() { return id; }
}