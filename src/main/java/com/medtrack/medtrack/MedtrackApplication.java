package com.medtrack.medtrack;

import com.medtrack.medtrack.model.DadosUsuario;
import com.medtrack.medtrack.service.ConsumirApi;
import com.medtrack.medtrack.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedtrackApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MedtrackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
