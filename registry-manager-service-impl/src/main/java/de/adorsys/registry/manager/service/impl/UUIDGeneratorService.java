package de.adorsys.registry.manager.service.impl;

import de.adorsys.registry.manager.repository.model.AspspPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UUIDGeneratorService {

    List<AspspPO> checkAndUpdateUUID (List<AspspPO> aspsps) {
        aspsps.forEach(this::checkAndUpdateUUID);
        return aspsps;
    }

    AspspPO checkAndUpdateUUID (AspspPO aspsp) {
        if (aspsp.getId() == null) {
            aspsp.setId(UUID.randomUUID());
        }
        return aspsp;
    }
}