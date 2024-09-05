package com.dominicjmarshall.zeldabosses.service;

import com.dominicjmarshall.zeldabosses.api.orm.boss.JsonBossesObject;
import com.dominicjmarshall.zeldabosses.api.service.DungeonsParser;
import com.dominicjmarshall.zeldabosses.model.Boss;
import com.dominicjmarshall.zeldabosses.model.BossRecord;
import com.dominicjmarshall.zeldabosses.repository.BossRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BossService {

    public List<Boss> mapJsonToBossList(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        JsonBossesObject jbo = null;
        try {
            jbo = objectMapper.readValue(json, JsonBossesObject.class);
        } catch (JsonProcessingException e) {
            System.err.println("Something went wrong converting the boss Json.");
        }

        List<Boss> bosses = new ArrayList<>();
        for (BossRecord bossRecord: jbo.data()){
            bosses.add(Boss.builder()
                    .name(bossRecord.name())
                    .description(bossRecord.description())
                    .dungeons(DungeonsParser.parseDungeons(bossRecord.dungeons()))
                    .build()
            );
        }
        return bosses;
    }

    @Autowired
    BossRepository bossRepository;

    public List<Boss> saveBosses(List<Boss> bosses){
        return (List) bossRepository.saveAll(bosses);
    }

}
