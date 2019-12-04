package examples.java.with.ravi.springdatasample.command;

public abstract class CloudCommand {
    protected Cloud cloud;

    public CloudCommand(Cloud cloud) {

        this.cloud = cloud;
    }

    public abstract void execute();
}
