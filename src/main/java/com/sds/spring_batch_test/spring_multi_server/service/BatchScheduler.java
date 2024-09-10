package com.sds.spring_batch_test.spring_multi_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class BatchScheduler {
    
    private final JobLauncher jobLauncher;
    private final Job job;

    public BatchScheduler(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @Scheduled(fixedDelay = 5000) // 5초마다 배치작업 실행
    public void runBatchJob() throws Exception {
        jobLauncher.run(job, new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters());
    }
    
}
