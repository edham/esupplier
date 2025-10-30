
package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product extends BaseEntity<String> {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id")
    private BusinessPartner businessPartner;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "producto_servicio")
    private String productoServicio;

    @Override
    public String getId() { return id; }
}
