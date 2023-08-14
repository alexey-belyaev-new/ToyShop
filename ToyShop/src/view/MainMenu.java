package view;

import view.command.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commandList;

    public MainMenu(View view){
        commandList = new ArrayList<>();
        commandList.add(new AddToy(view));
        commandList.add(new ReloadList(view));
        commandList.add(new loadList(view));
        commandList.add(new ShowToy(view));
        commandList.add(new WeightChanges(view));
        commandList.add(new RaffleToy(view));
        commandList.add(new Finish(view));
    }
    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++){
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void execute(int numCommand) throws IOException, ClassNotFoundException {
        commandList.get(numCommand - 1).execute();
    }
    public int size(){
        return commandList.size();
    }
}
