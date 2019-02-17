package org.SpringBootDemo;

import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@ComponentScan
//@ComponentScan("com.xxx.xxx") 可指定扫描包的范围，默认 逐层向下 扫描全部
public class Application {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

}
