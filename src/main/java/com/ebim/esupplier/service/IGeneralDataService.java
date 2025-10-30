
package com.ebim.esupplier.service;

import com.ebim.esupplier.web.dto.GeneralDataDTO;

public interface IGeneralDataService {
    GeneralDataDTO getgeneralData(Integer id);
    GeneralDataDTO savegeneralData(GeneralDataDTO generalDataDTO);
    GeneralDataDTO updatgeneralData(GeneralDataDTO generalDataDTO, Integer id);
    void deletegeneralData(Integer id);
}
