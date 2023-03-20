package com.example.gizem.yilmaz.infrastructure.repository;

import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class MongoSupportConfig {
    public static final WriteConcern MONGO_WRITE_CONCERN = WriteConcern
            .MAJORITY
            .withJournal(false)
            .withWTimeout(30, TimeUnit.SECONDS);

    @Bean
    MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory dbFactory) {
        MongoTransactionManager mongoTransactionManager = new MongoTransactionManager(dbFactory);
        mongoTransactionManager.setOptions(
                TransactionOptions
                        .builder()
                        .writeConcern(MONGO_WRITE_CONCERN)
                        .build()
        );
        return mongoTransactionManager;
    }


}
