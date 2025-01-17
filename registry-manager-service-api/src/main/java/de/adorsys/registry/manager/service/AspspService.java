package de.adorsys.registry.manager.service;


import de.adorsys.registry.manager.service.model.AspspBO;

import java.util.List;

public interface AspspService {

    AspspBO save(AspspBO aspsp);

    void saveAll(List<AspspBO> aspsps);

    void deleteById(String aspspId);

    void deleteAll();
}