package com.arno;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

// url h2 консоли: http://localhost:8080/h2-console
// url базы: jdbc:h2:mem:testdb

@SpringBootApplication
public class LibraryApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LibraryApp.class, args);

//        context.getBean(MisDemoService.class).callDemo();
//        context.getBean(MisDemoService.class).tokenDemo();
//        context.getBean(MisDemoService.class).userDemo();
//        context.getBean(MisDemoService.class).organizationDemo();
//        context.getBean(MisDemoService.class).medicationsDemo();

        try {
            Console.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
