package com.caiyide.primary;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @outhor liusiyu
 * @create 2018-10-18-10:36
 */
@Component
public class ScheduledService {
    @Scheduled(cron = "*/5 * * * * ?")
    public void scheduled() {
        System.out.println("111");
    }

    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        System.out.println("111");
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        System.out.println("111");
    }
}
