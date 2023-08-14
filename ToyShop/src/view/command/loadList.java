package view.command;

import view.View;

import java.io.IOException;

public class loadList implements Command {
    View view;

    public loadList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Загрузить лист из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.loadList();
    }
}
