package com.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
@MapperScan("com.spring.boot.dao.mapper")
public class MySpringBootApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(MySpringBootApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MySpringBootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class,args);
    }

}
