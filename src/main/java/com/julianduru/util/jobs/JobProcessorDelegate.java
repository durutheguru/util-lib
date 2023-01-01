package com.julianduru.util.jobs;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/**
 * created by julian on 20/03/2021
 */
public abstract class JobProcessorDelegate {


    static AtomicBoolean processing = new AtomicBoolean(false);


    Logger logger = Logger.getLogger(JobProcessorDelegate.class.getName());



    @Async
    public void run() throws Exception {
        if (processing.get()) {
            logger.info("Already in Progress. Returning..");
            return;
        }

        try {
            processing.set(true);
            logger.info("Processing... " + getClass().getName());
            doProcessing();
            logger.info("Done Processing... " + getClass().getName());
        }
        finally {
            processing.set(false);
        }
    }


    protected abstract void doProcessing() throws Exception;


}


