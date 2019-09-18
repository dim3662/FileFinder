package FileManager;

import SimpleGUI.SimpleGUI;

import java.io.File;
import java.util.HashMap;

import static SimpleGUI.SimpleGUI.fileName;

public class FileCollecction {
    public static HashMap<String, String> fileColection;
    public static String nameDirectory;

    public FileCollecction() {
        this.fileColection = new HashMap<String, String>();
        this.nameDirectory = "";
    }

    public static void zapolnCollection(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) {
            SimpleGUI.files.append("File is empty or file is not exist" + "\n");
            return;
        }

        for (File file : list) {
            if (file.isDirectory()) {
                zapolnCollection(file.getAbsolutePath());
            } else {
                String fullName=file.getName();
                fileColection.put(fullName,file.getAbsolutePath());
            }
        }
    }
}
