package br.paulocalderan.sprinng_boot_jpa;

import br.paulocalderan.sprinng_boot_jpa.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprinngBootJpaApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    public static void main(String[] args) {
        SpringApplication.run(SprinngBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
