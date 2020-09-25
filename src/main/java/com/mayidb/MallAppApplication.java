package com.mayidb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//开启定时任务

@ComponentScan({"com.mayidb"})
@EnableCaching
@EnableAsync
public class MallAppApplication {

	public static void main(String[] args) {
		 SpringApplication.run(MallAppApplication.class, args);
	}

}
