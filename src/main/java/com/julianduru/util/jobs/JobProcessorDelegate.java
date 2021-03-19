package com.julianduru.util.jobs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/**
 * created by julian on 20/03/2021
 */
public interface JobProcessorDelegate {


    AtomicBoolean processing = new AtomicBoolean(false);


    Logger logger = Logger.getLogger(JobProcessorDelegate.class.getName());



    default void run() {
        if (processing.get()) {
            logger.info("Already in Progress. Returning..");
            return;
        }

        try {
            processing.set(true);
            doProcessing();
        }
        finally {
            processing.set(false);
        }
    }


    void doProcessing();


}


