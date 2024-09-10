package com.sds.spring_batch_test.spring_multi_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
//@RequiredArgsConstructor
public class UpdateTasklet implements Tasklet {

    private final ExampleRepository exampleRepository;

    public UpdateTasklet(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }


    @Override
    @Transactional
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        exampleRepository.updateData();
        return RepeatStatus.FINISHED;
    }
}
