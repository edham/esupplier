
package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.SunatValidation;
import com.ebim.esupplier.web.dto.SunatValidationDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SunatValidationMapper {
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    SunatValidation toEntity(SunatValidationDTO dto);

    @Mapping(target="businessPartnerId", source="businessPartner.id")
    SunatValidationDTO toDTO(SunatValidation entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    void updateFromDTO(SunatValidationDTO dto, @MappingTarget SunatValidation entity);
}
