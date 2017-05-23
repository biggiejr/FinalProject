package api;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource("file:src/main/resources/Beans.xml")
public class Application {

    public static void main(String[] args) throws IOException {
       // ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/Beans.xml");
    	SpringApplication app= new SpringApplication(Application.class);
    	app.run();
    	VicinityLocator vic = new VicinityLocator();
       // SpringApplication.run(Application.class, args);
    }
    
}
