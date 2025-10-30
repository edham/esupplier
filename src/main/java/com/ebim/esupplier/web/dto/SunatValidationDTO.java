package com.ebim.esupplier.web.dto;

import lombok.Data;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class SunatValidationDTO {
    private Integer id;
    private Integer businessPartnerId;
    private String ruc;
    private String razonSocial;
    private String distrito;
    private String direccion;
    private String nuevoRus;
    private String provincia;
    private Instant validatedAt;
    private String departamento;
    private LocalDate fechaInicio;
    private String principalCiiu;
    private String nombreComercial;
    private Integer yearsInOperation;
    private LocalDate fechaInscripcion;
    private String buenContribuyente;
    private String tipoContribuyente;
    private String estadoContribuyente;
    private Boolean isValidForRegistration;
    private String condicionContribuyente;
}