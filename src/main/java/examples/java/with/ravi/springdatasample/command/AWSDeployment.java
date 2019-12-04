package examples.java.with.ravi.springdatasample.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AWSDeployment extends CloudCommand {

    public AWSDeployment(final Cloud cloud) {

        super(cloud);
    }

    @Override
    public void execute() {
        log.info("Deploying on AWS");
    }
}
