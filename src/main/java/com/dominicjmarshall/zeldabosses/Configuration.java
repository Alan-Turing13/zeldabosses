package com.dominicjmarshall.zeldabosses;

import com.dominicjmarshall.zeldabosses.service.BossService;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    BossService bossService(){
        return new BossService();
    }
}
