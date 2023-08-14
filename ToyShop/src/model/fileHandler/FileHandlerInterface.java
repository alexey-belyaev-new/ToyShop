package model.fileHandler;

import java.io.IOException;
import java.io.Serializable;

public interface FileHandlerInterface {
    void reloadList(Serializable serializable, String str) throws IOException;
    Object loadList(String str) throws IOException,ClassNotFoundException;
}
