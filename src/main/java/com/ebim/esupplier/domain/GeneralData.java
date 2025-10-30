
package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "general_data", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class GeneralData extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id")
    private BusinessPartner businessPartner;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "email")
    private String email;

    @Column(name = "company_name")
    private String companyName;

    @Override
    public Integer getId() { return id; }
}
