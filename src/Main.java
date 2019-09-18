import FileManager.FileCollecction;
import SimpleGUI.SimpleGUI;

public class Main {

    public static void main(String[] args) {
        FileCollecction fileCollecction=new FileCollecction();
        SimpleGUI app=new SimpleGUI(fileCollecction);
        app.setVisible(true);
    }
}
