package model.toys;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListToy<T extends Toy> implements Serializable {
    private final List<T> listToy;

    public ListToy() {
        listToy = new ArrayList<>();
    }

    public boolean addToy(T toy) {
        if (!listToy.contains(toy)) {
            listToy.add(toy);
        } else {
            return false;
        }
        return true;
    }

    public Toy weightChanges(int id) {
        if (listToy.size() != 0) {
            for (T toy : listToy) {
                if (toy.getId() == id) {
                    return toy;
                }
            }
        } else {
            return null;
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        if (listToy.size() != 0) {
            for (T toy : listToy) {
                sb.append(toy.getInfo());
                sb.append("\n");
            }
        } else {
            return null;
        }
        return sb.toString();
    }

    public T raffleToy() {
        Double chance = 0.0;
        for (T toy : listToy) {
            chance += toy.getWeight();
        }
        int idx = 0;
        for (Double r = Math.random() * chance; idx < listToy.size() - 1; ++idx) {
            r -= listToy.get(idx).getWeight();
            if (r <= 0.0) break;
        }
        if (idx == 0) {
            return null;
        } else {
            return listToy.get(idx);
        }
    }

    public void writeFile(T prizeToy) {
        try (FileWriter writer = new FileWriter("listPrize.txt", true)) {
            writer.write(prizeToy.getInfo());
            writer.append('\n');
        } catch (IOException | NullPointerException e) {
        }
        deleteToy(prizeToy);
    }

    private void deleteToy(T deleteToy) {
        if (deleteToy != null){
            listToy.removeIf(toy -> toy.equals(deleteToy));
        }

    }

}
