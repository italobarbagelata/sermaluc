package cl.ibarbagelata.sermaluc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("cl.ibarbagelata.sermaluc.model")
public class SermalucApplication {

	public static void main(String[] args) {
		SpringApplication.run(SermalucApplication.class, args);
	}

}
