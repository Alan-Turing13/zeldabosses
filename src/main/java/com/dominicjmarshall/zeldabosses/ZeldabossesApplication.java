package com.dominicjmarshall.zeldabosses;

import com.dominicjmarshall.zeldabosses.repository.BossRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZeldabossesApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZeldabossesApplication.class, args);
	}

}
