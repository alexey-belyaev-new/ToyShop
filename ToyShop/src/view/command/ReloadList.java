package view.command;

import view.View;

import java.io.IOException;

public class ReloadList implements Command {
    View view;

    public ReloadList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохратить лист";
    }

    @Override
    public void execute() throws IOException {
        view.reloadList();
    }
}
