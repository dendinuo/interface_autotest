package org.SpringBootDemo;
import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {
	@RequestMapping("/demo")
	@ResponseBody
	String home() {
		return "testtesttesttesttesttesttesttesttesttest...";
	}
	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);
	}
}
