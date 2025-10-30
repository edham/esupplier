
package com.ebim.esupplier.service.impl;

import com.ebim.esupplier.domain.BusinessPartner;
import com.ebim.esupplier.repository.BusinessPartnerRepository;
import com.ebim.esupplier.service.IBusinessPartnerService;
import com.ebim.esupplier.web.dto.BusinessPartnerDTO;
import com.ebim.esupplier.web.mapper.BusinessPartnerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusinessPartnerService implements IBusinessPartnerService {
    private final BusinessPartnerRepository repo;
    private final BusinessPartnerMapper mapper;

    public BusinessPartnerService(BusinessPartnerRepository repo, BusinessPartnerMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public BusinessPartnerDTO getbusinessPartner(Integer id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("BusinessPartner not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public BusinessPartnerDTO savebusinessPartner(BusinessPartnerDTO businessPartnerDTO) {
        var entity = mapper.toEntity(businessPartnerDTO);
        // Relationship fix if needed handled by mapper
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public BusinessPartnerDTO updatbusinessPartner(BusinessPartnerDTO businessPartnerDTO, Integer id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("BusinessPartner not found"));
        mapper.updateFromDTO(businessPartnerDTO, entity);
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void deletebusinessPartner(Integer id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("BusinessPartner not found");
        repo.deleteById(id);
    }
}
