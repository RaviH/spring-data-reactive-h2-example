package examples.java.with.ravi.springdatasample.command;

public class DevOps {

    private final CloudCommand cloudCommand;

    public DevOps(final CloudCommand cloudCommand) {

        this.cloudCommand = cloudCommand;
    }

    public void deploy() {

        cloudCommand.execute();
    }
}
