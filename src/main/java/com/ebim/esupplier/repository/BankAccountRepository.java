
package com.ebim.esupplier.repository;

import com.ebim.esupplier.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {}
