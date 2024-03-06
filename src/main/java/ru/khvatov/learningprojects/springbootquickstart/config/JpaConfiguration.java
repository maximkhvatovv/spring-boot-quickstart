package ru.khvatov.learningprojects.springbootquickstart.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.khvatov.learningprojects.springbootquickstart.config.condition.MyJpaCondition;

@Conditional({MyJpaCondition.class})
@Configuration
@Slf4j
public class JpaConfiguration {
    @PostConstruct
    void init() {
        log.info("{} is enabled", this.getClass().getSimpleName());
    }
}
