package PoiskManager;

import FileManager.FileCollecction;
import SimpleGUI.SimpleGUI;

import java.io.File;
import java.util.ArrayList;

public abstract class MorePoisk implements Poisk {
    public void walk( String Extencion, ArrayList<String> checkList) {
        FileCollecction.fileColection.keySet();
        if (FileCollecction.fileColection.keySet().isEmpty()) {
            SimpleGUI.files.append("File is empty or file is not exist" + "\n");
            return;
        }

        for (String name : FileCollecction.fileColection.keySet()) {
            if (Equals(name, Extencion)) {
                checkList.add(name);
                SimpleGUI.files.append(FileCollecction.fileColection.get(name) + "\n");
            }
        }
    }
}
