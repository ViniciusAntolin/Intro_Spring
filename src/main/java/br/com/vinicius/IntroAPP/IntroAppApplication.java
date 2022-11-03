package br.com.vinicius.IntroAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class IntroAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntroAppApplication.class, args);
    }

}