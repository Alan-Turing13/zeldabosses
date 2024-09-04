package com.dominicjmarshall.zeldabosses.api.service;

import com.dominicjmarshall.zeldabosses.api.dao.DungeonDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DungeonsParser {

    public static String parseDungeons(List<String> dungeons){

        DungeonDAO dungeonDAO = new DungeonDAO();
        DungeonService dungeonService = new DungeonService();
        StringBuilder sb = new StringBuilder();

        if (dungeons.isEmpty()) {
            sb.append("Location unknown");
        } else {
            sb.append("Known locations: \n");
            for (int i = 0; i < dungeons.size(); i++) {
                String dungeonJson = dungeonDAO.getDungeonJson(dungeons.get(i));
                sb.append(dungeonService.mapJsonToDungeon(dungeonJson));
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
