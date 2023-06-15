package com.wbj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wbj.mapper")
public class EasyCampusApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyCampusApplication.class, args);
    }

}
