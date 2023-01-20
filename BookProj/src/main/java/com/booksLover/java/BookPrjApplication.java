package com.booksLover.java;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan({"com.booksLover.java"})
//@MapperScan("com.booksLover.java.**.mapper") //mapper를 기본적으로 스캔할 주소값 지정
public class BookPrjApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookPrjApplication.class, args);
	}
	
	@RequestMapping("/")
	String home() {
		return "Hello World";
	}

}
