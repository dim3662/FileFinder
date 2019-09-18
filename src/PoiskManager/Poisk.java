package PoiskManager;

import java.io.File;
import java.util.ArrayList;

public interface Poisk {
    void walk( String Extencion, ArrayList<String> checkList);
    boolean Equals(String fileName, String Extencion);
}
