package com.journaldev.spring.mongodb.vanilla;

import com.journaldev.spring.mongodb.configurtion.RestTemplateConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

/**
 * Created by Viktor on 23.05.2018.
 */
public class TestCategory {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RestTemplateConfiguration.class);


        RestOperations rest = (RestOperations) ctx.getBean("rest");

        String baseUrl = "http://advocrowd-forum.andersenlab.com/vanilla-forum/api/categories/:namecomments";
        if (baseUrl == null) {
            return ;
        }

        ResponseEntity<String> response;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            response = rest.exchange(baseUrl, HttpMethod.GET,
                    new HttpEntity<>(null, params), String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

    }
}
