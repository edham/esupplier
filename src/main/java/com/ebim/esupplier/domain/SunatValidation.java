package com.ebim.esupplier.domain;

import com.ebim.esupplier.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "sunat_validations", schema = "esupplier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SunatValidation extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_partner_id", nullable = false)
    private BusinessPartner businessPartner;

    @Column(name = "ruc", nullable = false)
    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nuevo_rus")
    private String nuevoRus;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "validated_at")
    private Instant validatedAt;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "principal_ciiu")
    private String principalCiiu;

    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Column(name = "years_in_operation")
    private Integer yearsInOperation;

    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion;

    @Column(name = "buen_contribuyente")
    private String buenContribuyente;

    @Column(name = "tipo_contribuyente")
    private String tipoContribuyente;

    @Column(name = "estado_contribuyente")
    private String estadoContribuyente;

    @Column(name = "is_valid_for_registration")
    @Builder.Default
    private Boolean isValidForRegistration = false;

    @Column(name = "condicion_contribuyente")
    private String condicionContribuyente;

    @Override
    public Integer getId() { return id; }
}