package net.javaproject.lukas;

import net.javaproject.lukas.repository.PojisteniRepository;
import net.javaproject.lukas.repository.UzivatelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PojisteniSystem implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PojisteniSystem.class, args);
	}

	@Autowired
	private UzivatelRepository uzivatelRepository;

	@Autowired
	private PojisteniRepository pojisteniRepository;
	
	@Override
	public void run(String... args) throws Exception {

	}
}