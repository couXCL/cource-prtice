package com.xxx.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(basePackages = "com.xxx.course.dao")
@EnableEurekaClient
public class CourseListApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseListApplication.class,args);
    }

}
