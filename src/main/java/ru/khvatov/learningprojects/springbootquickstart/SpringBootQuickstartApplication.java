package ru.khvatov.learningprojects.springbootquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import ru.khvatov.learningprojects.springbootquickstart.config.DatabaseProperties;

import static java.lang.System.out;
import static java.util.Arrays.stream;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SpringBootQuickstartApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootQuickstartApplication.class, args);
        stream(ctx.getBeanDefinitionNames())
                .filter(n -> n.matches(".*DatabaseProperties.*"))
                .forEach(out::println);
        final DatabaseProperties databaseProperties = ctx.getBean("databaseProperties", DatabaseProperties.class);
        out.println(databaseProperties);
    }

}
