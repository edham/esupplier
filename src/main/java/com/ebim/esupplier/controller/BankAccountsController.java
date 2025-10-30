
package com.ebim.esupplier.controller;

import com.ebim.esupplier.domain.BankAccount;
import com.ebim.esupplier.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountsController extends BaseCrudController<BankAccount, String> {
    public BankAccountsController(BankAccountRepository repo) { super(repo); }
}
