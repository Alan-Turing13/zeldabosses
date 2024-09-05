package com.dominicjmarshall.zeldabosses.controller;

import com.dominicjmarshall.zeldabosses.api.dao.BossesDAO;
import com.dominicjmarshall.zeldabosses.model.Boss;
import com.dominicjmarshall.zeldabosses.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zelda/bosses")
public class BossController {

    @Autowired(required = false)
    BossService bossService;

    public List<Boss> getAllZeldaBossesFromExternalApi(){
        BossesDAO bossesDAO = new BossesDAO();
        return bossService.mapJsonToBossList(bossesDAO.getBossesJson());
    }

    @GetMapping("/save")
    public ResponseEntity<List<Boss>> saveZeldaBosses(){
        List<Boss> bosses = bossService.saveBosses(getAllZeldaBossesFromExternalApi());
        return new ResponseEntity<>(bosses, HttpStatus.CREATED);
    }

}
