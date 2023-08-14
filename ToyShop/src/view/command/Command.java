package view.command;

import java.io.IOException;

public interface Command {
    String getDescription();
    void execute() throws IOException, ClassNotFoundException;

}
