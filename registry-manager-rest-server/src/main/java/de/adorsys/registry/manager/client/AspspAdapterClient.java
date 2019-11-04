package de.adorsys.registry.manager.client;

import de.adorsys.registry.manager.config.ClientConfiguration;
import feign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(value = "aspsp-adapter-service", url = "${xs2a-adapter.url}",
    configuration = ClientConfiguration.class)
public interface AspspAdapterClient {

    /**
     * Requests for data from Adapter for putting it into the existing database
     *
     * @return records as an array of bytes
     */
    @RequestMapping(method = RequestMethod.GET, value = "/v1/aspsps/csv/export")
    byte[] importFile();

    /**
     * Sends records from the current repository into Adapter
     *
     * @param file as a {@link MultipartFile}
     */
    @RequestMapping(method = RequestMethod.POST, value = "/v1/aspsps/csv/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void exportFile(@Param("file") MultipartFile file);
}
