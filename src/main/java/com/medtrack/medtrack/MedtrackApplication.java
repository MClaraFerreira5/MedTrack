package com.medtrack.medtrack;

import com.medtrack.medtrack.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedtrackApplication{

    @Autowired
    private Principal principal;

    public static void main(String[] args) throws Exception {

        SpringApplication.run(MedtrackApplication.class, args);
    }


}
