package cn.cncic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Application {
@RequestMapping("/index")
@ResponseBody
String Hello(){
	return "Hello";
}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
