package com.siooka.siret.service.delegate;

import com.siooka.siret.common.config.ExternalConfiguration;
import com.siooka.siret.common.factory.SiretFactory;
import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class SiretDelegateServiceImpl implements SiretDelegateService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SiretFactory siretFactory;

    @Autowired
    private ExternalConfiguration externalConfig;

    public SiretDetailsDto getSiretDetails(String id) {
        URI url = URI.create(externalConfig.getUrl().replace("{id}", id));
        try {
            ResponseEntity<SiretDetailsDto> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, null, SiretDetailsDto.class);
            return response.getBody();
        } catch (ResourceAccessException e) {
            return siretFactory.getEmptySiret(e.getMessage());
        }
    }
}
