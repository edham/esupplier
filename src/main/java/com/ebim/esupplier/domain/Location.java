package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "locations", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Location extends BaseEntity<String> {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id", nullable = false)
    private BusinessPartner businessPartner;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "id_pais")
    private String idPais;

    @Column(name = "id_tipo")
    private String idTipo;

    @Column(name = "id_region")
    private String idRegion;

    @Column(name = "id_distrito")
    private String idDistrito;

    @Column(name = "id_tipo_zona")
    private String idTipoZona;

    @Column(name = "id_provincia")
    private String idProvincia;

    @Column(name = "id_tipo_calle")
    private String idTipoCalle;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "id_tipo_direccion")
    private String idTipoDireccion;

    @Override
    public String getId() { return id; }
}