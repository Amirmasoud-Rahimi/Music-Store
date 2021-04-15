package com.demisco.project.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import com.demisco.project.ProjectApplication;
import org.slf4j.*;

import java.util.Date;

@Service
public class AppListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectApplication.class);

    @EventListener
    public void onStartUp(ApplicationReadyEvent readyEvent) {
        LOGGER.info("Application Run << " + new Date(readyEvent.getTimestamp()) + " >> (Listener Message)");
    }
}