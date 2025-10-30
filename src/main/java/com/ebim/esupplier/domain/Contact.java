
package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contacts", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Contact extends BaseEntity<String> {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id")
    private BusinessPartner businessPartner;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "principal")
    private Boolean principal = false;

    @Override
    public String getId() { return id; }
}
