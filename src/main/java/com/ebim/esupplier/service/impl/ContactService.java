
package com.ebim.esupplier.service.impl;

import com.ebim.esupplier.domain.Contact;
import com.ebim.esupplier.repository.ContactRepository;
import com.ebim.esupplier.service.IContactService;
import com.ebim.esupplier.web.dto.ContactDTO;
import com.ebim.esupplier.web.mapper.ContactMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactService implements IContactService {
    private final ContactRepository repo;
    private final ContactMapper mapper;

    public ContactService(ContactRepository repo, ContactMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ContactDTO getcontact(String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Contact not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public ContactDTO savecontact(ContactDTO contactDTO) {
        var entity = mapper.toEntity(contactDTO);
        // Relationship fix if needed handled by mapper
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public ContactDTO updatcontact(ContactDTO contactDTO, String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Contact not found"));
        mapper.updateFromDTO(contactDTO, entity);
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void deletecontact(String id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("Contact not found");
        repo.deleteById(id);
    }
}
