package com.medtrack.medtrack;

import com.medtrack.medtrack.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class MedtrackApplication{

    @Autowired
    private Principal principal;

    public static void main(String[] args) throws Exception {

        Dotenv dotenv = Dotenv.configure().directory("D://medtrack//src//.env").load();

        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        SpringApplication.run(MedtrackApplication.class, args);
    }


}
