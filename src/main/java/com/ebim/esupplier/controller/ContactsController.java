
package com.ebim.esupplier.controller;

import com.ebim.esupplier.domain.Contact;
import com.ebim.esupplier.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController extends BaseCrudController<Contact, String> {
    public ContactsController(ContactRepository repo) { super(repo); }
}
