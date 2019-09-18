package FileManager;

import SimpleGUI.SimpleGUI;

import java.io.*;

public class SaverLoaderForFileCollection extends FileCollecction implements SaverLoader {
    public void saver() {
        File file = new File("C:\\Users\\Dmitry\\Google Drive\\Programs\\PrakticSummerTime\\SaverLoader");
        try {
            PrintWriter writ = new PrintWriter(file);
            writ.print("");
            writ.close();
            FileWriter writer = new FileWriter(file);
            writer.write(FileCollecction.nameDirectory + "\n");
            for (String key : FileCollecction.fileColection.keySet()) {
                writer.write(key + " " + FileCollecction.fileColection.get(key) + "\n");
            }
            writer.close();
            SimpleGUI.files.append("Your directory and files saved successfully" + "\n");
        } catch (Exception e) {
        }
    }

    public void loader() {
        File file = new File("C:\\Users\\Dmitry\\Google Drive\\Programs\\PrakticSummerTime\\SaverLoader");
        if (file.length() == 0) {
            SimpleGUI.files.append("You can't load your last save, because your save file is empty" + "\n");
        } else {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String directories = bufferedReader.readLine();
                SimpleGUI.labelFileName.setText(directories);
                FileCollecction.nameDirectory=directories;
                FileCollecction.fileColection.clear();
               /* String stok=bufferedReader.readLine();
                while (!stok.isEmpty()){
                    String[] strokSplit = stok.split(" ");
                    FileCollecction.fileColection.put(strokSplit[0],strokSplit[1]);
                    stok=bufferedReader.readLine();
                }*/
               FileCollecction.zapolnCollection(directories);
                fileReader.close();
                bufferedReader.close();
                SimpleGUI.files.append("Your directory and files load successfully" + "\n");
            } catch (Exception e) {

            }
        }
    }

    public void looker() {
       if(FileCollecction.fileColection.isEmpty()){
           SimpleGUI.files.append("You need to choose the file or directori before use this button" + "\n");
       }else{
           for (String key : FileCollecction.fileColection.keySet()) {
               SimpleGUI.files.append( FileCollecction.fileColection.get(key)+ "\n");
           }
       }

    }
}
