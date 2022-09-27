package br.com.springboot.testcontainer.example.config;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresqlDB extends PostgreSQLContainer<PostgresqlDB> {
    private static final String IMAGE_VERSION = "postgres:11.1";
    private static PostgresqlDB container;

    static {
        getInstance().start();
    }

    private PostgresqlDB() {
        super(IMAGE_VERSION);
    }

    public static PostgresqlDB getInstance() {
        if (container == null) {
            container = new PostgresqlDB();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
