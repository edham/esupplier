package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.BusinessPartner;
import com.ebim.esupplier.web.dto.BusinessPartnerDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BusinessPartnerMapper {
    @Mapping(target="user.id", source="userId")
    // Ignorar campos de auditoría explícitos en la entidad para que JPA/DB los maneje
    @Mapping(target="createdAt", ignore = true)
    @Mapping(target="lastModifiedAt", ignore = true)
    BusinessPartner toEntity(BusinessPartnerDTO dto);

    @Mapping(target="userId", source="user.id")
    BusinessPartnerDTO toDTO(BusinessPartner entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="id", ignore = true)
    @Mapping(target="createdAt", ignore = true)
    @Mapping(target="user.id", source="userId")
    void updateFromDTO(BusinessPartnerDTO dto, @MappingTarget BusinessPartner entity);
}