package com.dominicjmarshall.zeldabosses;

import com.dominicjmarshall.zeldabosses.model.Boss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepository extends CrudRepository<Boss, Long> {
}
