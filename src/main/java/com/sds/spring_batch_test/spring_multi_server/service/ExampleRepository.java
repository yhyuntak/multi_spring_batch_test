package com.sds.spring_batch_test.spring_multi_server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleRepository {

    private static final Logger log = LoggerFactory.getLogger(ExampleRepository.class);

    public void updateData() {
        log.debug("----------------------");
        log.debug("------HELLO BATCH-----");
        log.debug("----------------------");
    }
}
