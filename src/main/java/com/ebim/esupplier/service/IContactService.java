
package com.ebim.esupplier.service;

import com.ebim.esupplier.web.dto.ContactDTO;

public interface IContactService {
    ContactDTO getcontact(String id);
    ContactDTO savecontact(ContactDTO contactDTO);
    ContactDTO updatcontact(ContactDTO contactDTO, String id);
    void deletecontact(String id);
}
