package com.siooka.siret.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;
import java.util.Collections;

@Component
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Autowired
    ExternalConfiguration externalConfig;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        try {
            request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            request.getHeaders().setBearerAuth("656e388c-ed34-3010-9c85-fd8267f9569b");
            return execution.execute(request, body);
        }  catch (ResourceAccessException e) {
            return null;
        }

    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {

        if (externalConfig.getDebug().equalsIgnoreCase("true")) {
            System.out.println("===log request start===");
            System.out.println("URI: " + request.getURI());
            System.out.println("Method: " + request.getMethod());
            System.out.println("Headers: " + request.getHeaders());
            System.out.println("Request body: " + new String(body, "UTF-8"));
            System.out.println("===log request end===");
        }

    }

}
