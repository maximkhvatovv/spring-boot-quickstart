package ru.khvatov.learningprojects.springbootquickstart.config.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

@Slf4j
public class MyJpaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            Objects.requireNonNull(context.getClassLoader()).loadClass("org.postgresql.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            log.info("Failed to find org.postgresql.Driver class in classpath: {}", e.getMessage(), e);
            return false;
        }
    }
}
