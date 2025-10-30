package com.ebim.esupplier.domain;

import com.ebim.esupplier.security.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "business_partners", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BusinessPartner { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "BusinessPartner", nullable = false)
    private String businessPartnerCode;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "TaxId")
    private String taxId;

    @Column(name = "IsActive", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @Column(name = "ContactPerson")
    private String contactPerson;

    // Campos de auditoría explícitos
    @Column(name = "CreatedAt", nullable = false)
    @Builder.Default
    protected Instant createdAt = Instant.now();

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "LastModifiedAt")
    private Instant lastModifiedAt;

    @Column(name = "LastModifiedBy")
    private String lastModifiedBy;

    // Nuevos campos
    @Column(name = "SapBusinessPartnerId")
    private String sapBusinessPartnerId;

    @Column(name = "HomologationStatus", nullable = false)
    @Builder.Default
    private Integer homologationStatus = 0;

    @Column(name = "ProgressPercentage", nullable = false)
    @Builder.Default
    private Integer progressPercentage = 0;

    @Column(name = "SubmittedAt")
    private Instant submittedAt;

    @Column(name = "ReviewedAt")
    private Instant reviewedAt;

    @Column(name = "ApprovedAt")
    private Instant approvedAt;

    @Column(name = "EvaluatorComments")
    private String evaluatorComments;

    @Column(name = "ReviewedByUserId")
    private String reviewedByUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Column(name = "AcceptMarketing", nullable = false)
    @Builder.Default
    private Boolean acceptMarketing = false;

    @Column(name = "AcceptTerms", nullable = false)
    @Builder.Default
    private Boolean acceptTerms = false;

    @Column(name = "Address")
    private String address;

    @Column(name = "BusinessPartnerType")
    private String businessPartnerType;

    @Column(name = "Categories")
    private String categories; // Tipo String para arreglos PostgreSQL

    @Column(name = "City")
    private String city;

    @Column(name = "Code", nullable = false)
    private String code;

    @Column(name = "CompanyName", nullable = false)
    private String companyName;

    @Column(name = "ContactDepartment")
    private String contactDepartment;

    @Column(name = "ContactEmail")
    private String contactEmail;

    @Column(name = "ContactFirstName")
    private String contactFirstName;

    @Column(name = "ContactLastName")
    private String contactLastName;

    @Column(name = "Country")
    private String country;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "PostalCode")
    private String postalCode;

    // Relaciones existentes...

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CatalogItem> catalogItems = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Location> locations = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<BankAccount> bankAccounts = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<GeneralData> generalData = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<SunatValidation> sunatValidations = new ArrayList<>();

    @PreUpdate
    public void onUpdate() {
        this.lastModifiedAt = Instant.now();
    }

    public Integer getId() { return id; }
}