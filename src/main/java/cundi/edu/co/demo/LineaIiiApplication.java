package cundi.edu.co.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LineaIiiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication.run(LineaIiiApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(LineaIiiApplication.class); // Replace DemoApplication with your main class
    }

}
