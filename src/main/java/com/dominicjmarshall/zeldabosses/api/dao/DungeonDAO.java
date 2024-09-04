package com.dominicjmarshall.zeldabosses.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class DungeonDAO {

    public String getDungeonJson(String url){
        WebClient webClient = WebClient.create(url);

        return webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
