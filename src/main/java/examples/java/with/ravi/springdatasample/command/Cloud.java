package examples.java.with.ravi.springdatasample.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class Cloud {

    // History of executed commands
    private List<String> executedCommands = new ArrayList<String>();

    public void launchCommand(String command) {

        log.info("Executing: {} on cloud", command);
        this.executedCommands.add(command);
    }

    public List<String> getExecutedCommands() {

        return this.executedCommands;
    }
}
