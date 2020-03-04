package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

    @Scheduled(cron = "0 0 0 * * ?") //每天凌晨执行
    //@Scheduled(fixedRate = 10000)//10秒执行一次
    public void scheduleTime(){
        System.out.println("预约过期");
    }

    public void appointment(){//预约过期检测

    }
}
