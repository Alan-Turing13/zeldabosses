package com.dominicjmarshall.zeldabosses.api.dao;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class BossesDAO {

    public String getBossesJson(){
        WebClient webClient = WebClient.create("https://zelda.fanapis.com/");

        return webClient.get()
                .uri("/api/bosses?limit=100")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
