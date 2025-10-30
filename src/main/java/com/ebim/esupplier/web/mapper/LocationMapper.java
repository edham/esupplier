package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.Location;
import com.ebim.esupplier.web.dto.LocationDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    Location toEntity(LocationDTO dto);

    @Mapping(target="businessPartnerId", source="businessPartner.id")
    LocationDTO toDTO(Location entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    void updateFromDTO(LocationDTO dto, @MappingTarget Location entity);
}