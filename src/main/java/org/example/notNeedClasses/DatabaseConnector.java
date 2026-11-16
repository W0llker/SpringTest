package org.example.notNeedClasses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnector {
    @Value("${database-connector.host}")
    private String url;
    @Value("${database-connector.credentials.username}")
    private String username;
    @Value("${database-connector.credentials.password}")
    private String password;

    public void executeSQL(String sql) {
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        System.out.println("все гуд");
    }
}
