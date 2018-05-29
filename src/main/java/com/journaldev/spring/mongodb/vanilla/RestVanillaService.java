package com.journaldev.spring.mongodb.vanilla;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

/**
 * Created by Viktor on 22.05.2018.
 */

@Service
public class RestVanillaService {
    private RestOperations restTemplate;

    public RestVanillaService(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }



    public void sendSSO() {
        String baseUrl = "https://advocrowd-forum.andersenlab.com/vanilla-forum/index.php? sso=eyAidW5pcXVlaWQiOiAiMTQwIiwgImVtYWlsIjogImFkdm8yQHVrci5uZXQiLCAibmFtZSI6ICJhZHZvMkB1a3IubmV0IiwgInBob3RvdXJsIjogImh0dHA6Ly9hZHZvY2F0ZWdhdGV3YXkuYW5kZXJzZW5sYWIuY29tL2FjYWRtaW4vYXBpL2Fkdm9jYXRlL2Fkdm9jYXRlX3Byb2ZpbGVfazRtY3hxanpzODRlaHB5cWxha3RwdXdvZmNkeGRmZGdvMG4xL3Byb2ZpbGUiLCAiY2xpZW50X2lkIjogIjE2NTUzMjk4MTAiIH0%3D%20c1c16203fb98fe32df1035f5c1811be05a008e8b%201526975513%20hmacsha1";
        if (baseUrl == null) {
            return ;
        }

        ResponseEntity<Void> response;
        try {
            response = restTemplate.getForEntity(baseUrl, Void.class);
            System.out.println(response.getStatusCode().toString());
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }
}
