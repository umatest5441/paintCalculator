package com.sherwin.paintassessment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Paint Area Calculator"))
public class PaintingAreaCalculator {

    public static void main(String[] args) {
        SpringApplication.run(PaintingAreaCalculator.class, args);
    }


}
