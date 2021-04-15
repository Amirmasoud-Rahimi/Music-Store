package com.demisco.project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.boot.SpringApplication;

/**
 * Music Store Web Application:
 * An online music store is an online business which sells audio files over the Internet,
 * usually sound recordings of music songs or classical pieces,
 * in which the user pays on a per-song or subscription basis.
 * Date: 2020/04
 *
 * @author Amirmasoud Rahimi
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
public class ProjectApplication implements WebMvcConfigurer {


    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Music");
    }
}