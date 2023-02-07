package com.siooka.siret.service.delegate;

import com.siooka.siret.common.config.ExternalConfiguration;
import com.siooka.siret.common.factory.SiretFactory;
import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;

import java.net.URI;
import java.util.Collections;

@Service
public class SiretDelegateServiceImpl implements SiretDelegateService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SiretFactory siretFactory;

    @Autowired
    private ExternalConfiguration externalConfig;

    public SiretDetailsDto getSiretDetails(String token, String id) {
        URI url = URI.create(externalConfig.getUrl().replace("{id}", id));
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setBearerAuth(token);
            HttpEntity<String> entity = new HttpEntity<>(null, headers);
            ResponseEntity<SiretDetailsDto> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, SiretDetailsDto.class);
            return response.getBody();
        } catch (ResourceAccessException e) {
            return siretFactory.getEmptySiret(e.getMessage());
        }
    }
}
