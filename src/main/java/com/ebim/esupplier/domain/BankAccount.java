package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bank_accounts", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount extends BaseEntity<String> {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id", nullable = false)
    private BusinessPartner businessPartner;

    @Column(name = "cuenta", nullable = false)
    private String cuenta;

    @Column(name = "cci")
    private String cci;

    @Column(name = "iban")
    private String iban;

    @Column(name = "aba")
    private String aba;

    @Column(name = "swif")
    private String swif;

    @Column(name = "id_pais")
    private String idPais;

    @Column(name = "id_tipo")
    private String idTipo;

    @Column(name = "entidad")
    private String entidad;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "id_tipo_pro")
    private String idTipoPro;

    @Column(name = "id_tipo_moneda")
    private String idTipoMoneda;

    @Column(name = "id_entidad_bancaria")
    private String idEntidadBancaria;

    @Override
    public String getId() { return id; }
}