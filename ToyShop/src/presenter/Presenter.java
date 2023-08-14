package presenter;

import model.service.Service;
import model.toys.Toy;
import view.View;

import java.io.IOException;

public class Presenter {
    private final Service service;

    public Presenter(Service service, View view) {
        this.service = service;
        view.setPresenter(this);
    }

    public boolean addToy(int id, String title, double weight) {
        return service.addToy(id, title, weight);
    }

    public Toy weightChanges(int id) {
        return service.weightChanges(id);
    }

    public String getInfo() {
        return service.getInfo();
    }

    public void reloadList(String str) throws IOException {
        service.reloadList(str);
    }

    public void loadList(String str) throws IOException, ClassNotFoundException {
        service.loadList(str);
    }

    public Toy raffleToy() {
        return service.raffleToy();
    }

    public void writeFile(Toy prizeToy){
        service.writeFile(prizeToy);
    }
}
