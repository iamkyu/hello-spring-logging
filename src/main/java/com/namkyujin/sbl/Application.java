package com.namkyujin.sbl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class Application {
    static final String ERROR_MESSAGE = "Hello World1";
    static final String WARN_MESSAGE = "Hello World2";
    static final String INFO_MESSAGE = "Hello World3";
    static final String DEBUG_MESSAGE = "Hello World4";
    static final String TRACE_MESSAGE = "Hello World5";


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    public static class CustomApplicationRunner implements ApplicationRunner {
        private final Logger LOG = LoggerFactory.getLogger(this.getClass());

        @Override
        public void run(ApplicationArguments args) throws Exception {
            LOG.error(ERROR_MESSAGE);
            LOG.warn(WARN_MESSAGE);
            LOG.info(INFO_MESSAGE);

            LOG.debug(DEBUG_MESSAGE);
            LOG.trace(TRACE_MESSAGE);
        }
    }
}
