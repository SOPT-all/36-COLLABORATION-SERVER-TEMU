package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Sopt36CollaborationServerTemuApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sopt36CollaborationServerTemuApplication.class, args);
	}

}
