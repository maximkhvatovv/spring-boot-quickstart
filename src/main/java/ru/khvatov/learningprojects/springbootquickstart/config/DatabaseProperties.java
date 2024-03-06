package ru.khvatov.learningprojects.springbootquickstart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "database.props")
@Data
public class DatabaseProperties {
    private final String username;
    private final String password;
    private final String driverName;

    @ConstructorBinding
    public DatabaseProperties(String username, String password, String driverName) {
        this.username = username;
        this.password = password;
        this.driverName = driverName;
    }
}
