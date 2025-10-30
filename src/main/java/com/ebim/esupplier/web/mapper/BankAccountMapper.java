package com.ebim.esupplier.web.mapper;

import com.ebim.esupplier.domain.BankAccount;
import com.ebim.esupplier.web.dto.BankAccountDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    BankAccount toEntity(BankAccountDTO dto);

    @Mapping(target="businessPartnerId", source="businessPartner.id")
    BankAccountDTO toDTO(BankAccount entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="businessPartner.id", source="businessPartnerId")
    void updateFromDTO(BankAccountDTO dto, @MappingTarget BankAccount entity);
}