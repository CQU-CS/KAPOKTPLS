package com.cqu.kapok.kapoktpls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqu.kapok.kapoktpls.dao")
public class KapoktplsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KapoktplsApplication.class, args);
	}

}
