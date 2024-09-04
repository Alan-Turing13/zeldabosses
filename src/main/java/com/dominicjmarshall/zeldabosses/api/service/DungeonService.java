package com.dominicjmarshall.zeldabosses.api.service;

import com.dominicjmarshall.zeldabosses.api.orm.dungeon.JsonDungeonObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DungeonService {

    public static String mapJsonToDungeon(String json){

        ObjectMapper objectMapper = new ObjectMapper();
        JsonDungeonObject jdo = null;
        try {
            jdo = objectMapper.readValue(json, JsonDungeonObject.class);
        } catch (JsonProcessingException e) {
            System.err.println("Something went wrong converting the dungeon Json.");
        }

        return jdo.data().name();

    }
}
