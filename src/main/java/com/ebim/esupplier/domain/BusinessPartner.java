
package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "business_partners", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BusinessPartner extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BusinessPartner")
    private String businessPartnerCode;

    @Column(name = "Name")
    private String name;

    @Column(name = "TaxId")
    private String taxId;

    @Column(name = "IsActive")
    private Boolean isActive = true;

    @Column(name = "Email")
    private String email;

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CatalogItem> catalogItems = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankAccount> bankAccounts = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeneralData> generalData = new ArrayList<>();

    @OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SunatValidation> sunatValidations = new ArrayList<>();

    @Override
    public Integer getId() { return id; }
}
