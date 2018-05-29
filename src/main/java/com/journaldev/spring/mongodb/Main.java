package com.journaldev.spring.mongodb;


import com.journaldev.spring.mongodb.vanilla.VanillaForumConnectService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Viktor on 23.05.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RestTemplateConfiguration.class);


        /*CloseableHttpClient httpClient = HttpClientBuilder
            .create()
            .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);*/

        //RestOperations rest = (RestOperations) ctx.getBean("restTemplate");

        /*String baseUrl = "http://advocrowd-forum.andersenlab.com/vanilla-forum/api/categories";
        if (baseUrl == null) {
            return ;
        }

        ResponseEntity<String> response;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        params.set(HttpHeaders.CACHE_CONTROL, "no-cache");
        try {
            response = restTemplate.exchange(baseUrl, HttpMethod.GET,
                new HttpEntity<>(null, params), String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }*/


        String forumURL = "http://advocrowd-forum.andersenlab.com/vanilla-forum/";
        Map user = new LinkedHashMap();
        user.put("uniqueid", "27");
        user.put("email", "topixog@eth2btc.info");
        user.put("name", "topixog@eth2btc.info");


        //RestTemplate restTemplate = new RestTemplate();
        String sso = null;
        try {
            sso = VanillaForumConnectService.SSOString(user);
        } catch (InvalidKeyException e) {
            //log.error("Login to forum failed.");
            e.printStackTrace();
        }
        String fullURL = forumURL+"?sso="+sso;

        OkHttpClient client1 = new OkHttpClient();

        Request request2 = new Request.Builder()
            .url(fullURL)
            .get()
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .addHeader("Cache-Control", "no-cache")
            .build();

        Response response = client1.newCall(request2).execute();



        System.out.println("-------------");
        System.out.println("body of resp after sso - " + response.body().string());
        System.out.println("Headers of resp after sso - " + response.headers().toString());

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url("http://advocrowd-forum.andersenlab.com/vanilla-forum/api/categories/2")
            .addHeader("Accept", "application/json")
            .addHeader("Cache-Control", "private, no-cache, no-store, max-age=0, must-revalidate")
            /*.addHeader("Cookie", "Vanilla=20-1529743768%7C85842a75e58669020e83eeaf0d3c456d%7C1527151768%7C20%7C1529743768; path=/; domain=.advocrowd-forum.andersenlab.com; HttpOnly; Expires=Sat, 23 Jun 2018 08:49:30 GMT;")*/
            .build();

        Response response1 = client.newCall(request).execute();
        System.out.println(response1.toString());
        ResponseEntity<String> responseEntity = null;
        if (response1.code() == 200){
            responseEntity = new ResponseEntity<String>(response1.body().string(), HttpStatus.OK);
        }
        System.out.println(responseEntity.getBody());



        /*HttpResponse<String> response = Unirest.get("http://advocrowd-forum.andersenlab.com/vanilla-forum/api/categories")
            .header("Accept", "application/json")
            .header("Cache-Control", "no-cache")
            .asString();
        System.out.println(response.getBody());*/

    }
}
