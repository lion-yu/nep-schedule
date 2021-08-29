package com.zenin.nepschedule.configuration;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author 86227
 * @date 2021/8/29 19:48
 */
@Configuration
public class MongoClient {

    @Value("${mongodb.url}")
    private String url;
    @Value("${mongo.database}")
    private String database;
    @Value("${mongo.running.database}")
    private String runningDatabase;

    @Primary
    @Bean("database")
    public MongoTemplate getMongoTemplate() {
        return new MongoTemplate(MongoClients.create(url), database);
    }

    @Bean("runningDatabase")
    public MongoTemplate getRunningDataMongoTemplate() {
        return new MongoTemplate(MongoClients.create(url), runningDatabase);
    }

}
