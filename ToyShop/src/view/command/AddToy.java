package view.command;

import view.View;

public class AddToy implements Command{
    private final View view;

    public AddToy(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить игрушку";
    }

    @Override
    public void execute() {
        view.addToy();
    }
}
