package com.journaldev.spring.mongodb.vanilla;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by Viktor on 22.05.2018.
 */
public class TestSignOut {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), "{\"id\":1,\"title\":\"Zone_Test\",\"fillColor\":\"1\",\"strokeColor\":\"1\",\"city\":{\"id\":2,\"title\":\"Odessa\",\"country\":{\"id\":1,\"title\":\"Ukraine\"}},\"points\":[{\"latitude\":-15.411319377980995,\"longitude\":29.0478515625,\"numberInSequence\":0},{\"latitude\":-17.392579271057766,\"longitude\":28.575439453125,\"numberInSequence\":1},{\"latitude\":-19.87005983797395,\"longitude\":30.1904296875,\"numberInSequence\":2},{\"latitude\":-20.354927584117682,\"longitude\":32.113037109375,\"numberInSequence\":3},{\"latitude\":-19.22817673776625,\"longitude\":33.64013671875,\"numberInSequence\":4},{\"latitude\":-17.853290114098,\"longitude\":35.035400390625,\"numberInSequence\":5},{\"latitude\":-16.46769474828896,\"longitude\":33.8818359375,\"numberInSequence\":6},{\"latitude\":-14.71644778364871,\"longitude\":33.0853271484375,\"numberInSequence\":7},{\"latitude\":-14.65799740350299,\"longitude\":31.409912109375,\"numberInSequence\":8}]}");
        Request request = new Request.Builder()
                .url("https://advocrowd-forum.andersenlab.com/vanilla-forum/entry/signout")
                .post(requestBody)
                .addHeader("Cache-Control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println("Resp"+response.code()+ response.headers().toString() + response.body().string());

    }
}
