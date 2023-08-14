package view;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void setPresenter(Presenter presenter);
    void start() throws IOException, ClassNotFoundException;
    void addToy();
    void reloadList() throws IOException;
    void loadList() throws IOException,ClassNotFoundException;
    void showList();
    void weightChanges();
    void raffleToy();
    void finish();
}
