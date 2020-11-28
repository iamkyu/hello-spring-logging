package com.namkyujin.sbl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class Application {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.error("Hello World1");
        LOG.warn("Hello World2");
        LOG.info("Hello World3");

        LOG.debug("Hello World4");
        LOG.trace("Hello World5");
    }
}
