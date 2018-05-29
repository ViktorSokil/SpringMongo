package com.journaldev.spring.mongodb.vanilla;

import com.journaldev.spring.mongodb.configurtion.RestTemplateConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import java.security.InvalidKeyException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Viktor on 22.05.2018.
 */
public class Main {
    public static void main(String[] args) throws InvalidKeyException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RestTemplateConfiguration.class);

        Map user = new LinkedHashMap();
        user.put("uniqueid", "27");
        user.put("email", "topixog@eth2btc.info");
        user.put("name", "topixog@eth2btc.info");
        RestOperations rest = (RestOperations) ctx.getBean("rest");
        String baseUrl = "https://advocrowd-forum.andersenlab.com/vanilla-forum/index.php?sso="+VanillaForumConnectService.SSOString(user);
        if (baseUrl == null) {
            return ;
        }

        ResponseEntity<Void> response;
        try {
            response = rest.getForEntity(baseUrl, Void.class);
            System.out.println(response.getStatusCode().toString());
        } catch (RestClientException e) {
            e.printStackTrace();
        }

    }
}
