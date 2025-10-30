
package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sunat_validations", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SunatValidation extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id")
    private BusinessPartner businessPartner;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Override
    public Integer getId() { return id; }
}
