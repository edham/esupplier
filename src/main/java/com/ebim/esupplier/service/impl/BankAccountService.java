
package com.ebim.esupplier.service.impl;

import com.ebim.esupplier.domain.BankAccount;
import com.ebim.esupplier.repository.BankAccountRepository;
import com.ebim.esupplier.service.IBankAccountService;
import com.ebim.esupplier.web.dto.BankAccountDTO;
import com.ebim.esupplier.web.mapper.BankAccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankAccountService implements IBankAccountService {
    private final BankAccountRepository repo;
    private final BankAccountMapper mapper;

    public BankAccountService(BankAccountRepository repo, BankAccountMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public BankAccountDTO getbankAccount(String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("BankAccount not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public BankAccountDTO savebankAccount(BankAccountDTO bankAccountDTO) {
        var entity = mapper.toEntity(bankAccountDTO);
        // Relationship fix if needed handled by mapper
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public BankAccountDTO updatbankAccount(BankAccountDTO bankAccountDTO, String id) {
        var entity = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("BankAccount not found"));
        mapper.updateFromDTO(bankAccountDTO, entity);
        entity = repo.save(entity);
        return mapper.toDTO(entity);
    }

    @Override
    public void deletebankAccount(String id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("BankAccount not found");
        repo.deleteById(id);
    }
}
