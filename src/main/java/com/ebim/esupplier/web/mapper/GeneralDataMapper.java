package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.GeneralData;
import com.ebim.esupplier.web.dto.GeneralDataDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GeneralDataMapper {
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    GeneralData toEntity(GeneralDataDTO dto);

    @Mapping(target="businessPartnerId", source="businessPartner.id")
    GeneralDataDTO toDTO(GeneralData entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    void updateFromDTO(GeneralDataDTO dto, @MappingTarget GeneralData entity);
}