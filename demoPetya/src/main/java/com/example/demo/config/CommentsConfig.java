package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jsonplaceholder")
public class CommentsConfig {
    private String schema;
    private String host;
    private String path;



    public String getSchema() {
        return schema;
    }

    public CommentsConfig setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public String getHost() {
        return host;
    }

    public CommentsConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public String getPath() {
        return path;
    }

    public CommentsConfig setPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        return "CommentsConfig{" +
                "schema='" + schema + '\'' +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
