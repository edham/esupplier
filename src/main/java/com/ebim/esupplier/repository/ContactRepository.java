
package com.ebim.esupplier.repository;

import com.ebim.esupplier.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {}
