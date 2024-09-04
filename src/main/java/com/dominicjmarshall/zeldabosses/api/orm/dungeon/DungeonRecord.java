package com.dominicjmarshall.zeldabosses.api.orm.dungeon;

import java.util.List;

public record DungeonRecord(
        List<String> appearances,
        String name,
        String description,
        String id
) {
}
