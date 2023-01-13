package br.gov.ma.cessaoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"br.gov.ma.cessaoapi"}, exclude = { FreeMarkerAutoConfiguration.class })
@EnableScheduling
@EnableTransactionManagement
public class CessaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CessaoApiApplication.class, args);
	}

}
