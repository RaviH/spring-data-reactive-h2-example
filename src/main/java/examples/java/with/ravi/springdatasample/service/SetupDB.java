package examples.java.with.ravi.springdatasample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class SetupDB implements ApplicationListener<ContextRefreshedEvent> {

    final DatabaseClient databaseClient;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        log.info("Creating schema");
        List<String> statements = Arrays.asList(//
                "DROP TABLE IF EXISTS customer;",
                "CREATE TABLE customer ( id SERIAL PRIMARY KEY, first_name VARCHAR(100) NOT NULL, last_name VARCHAR(100) NOT NULL);");


        statements.forEach(it -> databaseClient.execute(it) //
                .fetch() //
                .rowsUpdated()
                .as(StepVerifier::create)
                .expectNextCount(1) //
                .verifyComplete());

        log.info("Done creating schema");
    }
}
