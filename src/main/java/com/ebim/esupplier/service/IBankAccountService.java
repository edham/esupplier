
package com.ebim.esupplier.service;

import com.ebim.esupplier.web.dto.BankAccountDTO;

public interface IBankAccountService {
    BankAccountDTO getbankAccount(String id);
    BankAccountDTO savebankAccount(BankAccountDTO bankAccountDTO);
    BankAccountDTO updatbankAccount(BankAccountDTO bankAccountDTO, String id);
    void deletebankAccount(String id);
}
