package model.fileHandler;

import java.io.*;

public class FileHandlerToy implements FileHandlerInterface{
    public FileHandlerToy() {
    }

    @Override
    public void reloadList(Serializable serializable, String str) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(str));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object loadList(String str) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(str));
        return objectInputStream.readObject();
    }
}
