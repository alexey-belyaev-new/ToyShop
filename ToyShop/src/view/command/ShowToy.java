package view.command;

import view.View;

public class ShowToy implements Command{
    View view;

    public ShowToy(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать список";
    }

    @Override
    public void execute() {
        view.showList();
    }
}
