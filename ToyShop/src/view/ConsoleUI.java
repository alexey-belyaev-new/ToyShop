package view;

import model.toys.Toy;
import presenter.Presenter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private final Scanner scanner;
    private final MainMenu mainMenu;
    private boolean flag;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        flag = true;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Добро пожаловать в приложение Розыгрыш игрушек");
        while (flag) {
            System.out.println(mainMenu.print());
            execute();
        }
    }

    private void execute() throws IOException, ClassNotFoundException {
        String num = scanner.nextLine();
        if (checkNum(num)) {
            int numCommand = Integer.parseInt(num);
            if (checkCommand(numCommand)) {
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand > 0 && numCommand <= mainMenu.size()) {
            return true;
        } else {
            System.out.println("Ошибка ввода");
            return false;
        }
    }

    private boolean checkNum(String num) {
        if (num.equalsIgnoreCase("-")) {
            System.out.println("Ошибка ввода");
            return false;
        } else if (!num.matches("[0-9]+")) {
            System.out.println("Ошибка ввода");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void addToy() {
        int id = setId();
        String title = setTitle();
        double weight = setWeight();
        if (presenter.addToy(id, title, weight)) {
            System.out.println("Игрушка добавлена.");
        }else {
            System.out.println("Игршка уже в базе");
        }
    }

    @Override
    public void reloadList() throws IOException {
        System.out.println("Введите имя файла: ");
        String saveName = scanner.nextLine();
        String saveStr = saveName + ".out";
        presenter.reloadList(saveStr);
        System.out.println("Запись сохранена.");
    }

    @Override
    public void loadList() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя файла: ");
        boolean flag = false;
        String saveName = scanner.nextLine();
        String saveStr = saveName + ".out";
        try {
            presenter.loadList(saveStr);
        } catch (FileNotFoundException exception) {
            System.out.println("Файл не найден");
            flag = true;
        }
        if (!flag) {
            System.out.println("Запись загружена.");
        }
    }

    @Override
    public void showList() {
        if (presenter.getInfo() == null){
            System.out.println("Список пуст.");
        }else {
            System.out.println(presenter.getInfo());
        }

    }

    private Integer setId() {
        String id;
        do {
            System.out.println("Введите id: ");
            id = scanner.nextLine();
            if (checkNum(id)){
                System.out.println("Введено некорректное значение. Повторите ввод.");
            }
        }while (checkLine(id));
        return Integer.parseInt(id);
    }

    private String setTitle() {
        System.out.println("Введите наименование: ");
        return scanner.nextLine();
    }

    private double setWeight() {
        String weight;
        do {
            System.out.println("Введите вес: ");
            weight = scanner.nextLine();
            if (checkLine(weight)) {
                System.out.println("Введено некорректное значение. Повторите ввод.");
            }
        } while (checkLine(weight));
        return Double.parseDouble(weight);
    }

    private boolean checkLine(String line) {
        return !line.matches("[0-9]+");
    }

    @Override
    public void weightChanges() {
        System.out.println("Введите id для поиска: ");
        String findId = scanner.nextLine();
        Toy changeToy = presenter.weightChanges(Integer.parseInt(findId));
        if (changeToy != null) {
            System.out.println("Изменяемая запись: \n" + changeToy.getInfo());
            double newWeight = setWeight();
            changeToy.setWeight(newWeight);
        }else{
            System.out.println("Игрушка не найдена");
        }
    }

    @Override
    public void raffleToy() {
        if (presenter.raffleToy() == null){
            System.out.println("Список пуст.");
        }else {
            Toy prizeToy = presenter.raffleToy();
            System.out.println("Выпала игрушка: " + prizeToy.getInfo());
            presenter.writeFile(prizeToy);
        }

    }


    @Override
    public void finish() {
        System.out.println("Работа закончена.");
        flag = false;
    }
}
