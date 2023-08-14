package view.command;

import view.View;

public class RaffleToy implements Command{
    View view;

    public RaffleToy(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Разыграть игруку";
    }

    @Override
    public void execute() {
        view.raffleToy();
    }
}
