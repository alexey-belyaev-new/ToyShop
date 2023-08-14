package view.command;

import view.View;

public class WeightChanges implements Command{
    View view;

    public WeightChanges(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Изменить вес игрушки";
    }

    @Override
    public void execute() {
        view.weightChanges();
    }
}
