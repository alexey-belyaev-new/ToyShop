package model.service;

import model.fileHandler.FileHandlerInterface;
import model.fileHandler.FileHandlerToy;
import model.toys.ListToy;
import model.toys.Toy;

import java.io.IOException;

public class Service {
    private ListToy<Toy> listToy;
    private final FileHandlerInterface fileHandlerInterface;


    public Service(ListToy<Toy> listToy, FileHandlerInterface fileHandlerInterface) {
        this.listToy = listToy;
        this.fileHandlerInterface = fileHandlerInterface;
    }

    public Service() {
        this(new ListToy<>(), new FileHandlerToy());

    }

    public boolean addToy(int id, String title, double weight) {
        return listToy.addToy(new Toy(id, title, weight));
    }

    public Toy weightChanges(int id) {
        return listToy.weightChanges(id);
    }

    public String getInfo() {
        return listToy.getInfo();
    }

    public void reloadList(String str) throws IOException {
        fileHandlerInterface.reloadList(listToy, str);
    }

    public void loadList(String str) throws IOException, ClassNotFoundException {
        listToy = (ListToy<Toy>) fileHandlerInterface.loadList(str);
    }

    public Toy raffleToy() {
        return listToy.raffleToy();
    }

    public void writeFile(Toy prizeToy){
        listToy.writeFile(prizeToy);
    }
}
