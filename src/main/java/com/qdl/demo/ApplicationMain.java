package com.qdl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Created by QinDongLiang on 2017/10/28.
 */
@SpringBootApplication
@Configuration
//加上这行注释避免没有引入数据库驱动，导致工程起不来的问题
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
