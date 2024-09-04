package com.dominicjmarshall.zeldabosses.api.orm.boss;

import com.dominicjmarshall.zeldabosses.model.BossRecord;
import java.util.List;

public record JsonBossesObject (
        boolean success,
        int count,
        List<BossRecord> data
) {}
