package br.gov.ma.cessaoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"br.gov.ma.cessaoapi"}, exclude = { FreeMarkerAutoConfiguration.class })
@EnableSwagger2
@EnableScheduling
@EnableTransactionManagement
public class CessaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CessaoApiApplication.class, args);
	}

}
