package examples.java.with.ravi.springdatasample.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

@Component
public class CommandOrchestrator {

    private List<CloudCommand> cloudCommandList;

    @Autowired
    public CommandOrchestrator(
            final List<CloudCommand> cloudCommandList
    ) {

        this.cloudCommandList = cloudCommandList;
    }

    public void orchestrate() {

        cloudCommandList.forEach(new Consumer<CloudCommand>() {
            @Override
            public void accept(final CloudCommand cloudCommand) {
                new DevOps(cloudCommand).deploy();
            }
        });
    }
}
