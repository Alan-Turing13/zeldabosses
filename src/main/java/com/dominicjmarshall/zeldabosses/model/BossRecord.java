package com.dominicjmarshall.zeldabosses.model;

import java.util.List;

public record BossRecord(
        List<String> appearances,
        List<String> dungeons,
        String name,
        String description,
        String id
) {
}
