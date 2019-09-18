package Listeners;

import PoiskManager.PoiskForExtencion;
import PoiskManager.PoiskForStart;
import SimpleGUI.SimpleGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class ButtonSearchListener implements ActionListener {
  public  ArrayList<String> checkList=new ArrayList<String>();
    public void actionPerformed(ActionEvent e) {
        String fileName = SimpleGUI.labelFileName.getText();
        if(fileName.equals("File name")) {
            SimpleGUI.files.append("Please, choose the name of directory" + "\n");
            return;
        }
        String fileExtenxion = SimpleGUI.fileExtenxion.getText();
        if (SimpleGUI.extencion.isSelected()) {
            PoiskForExtencion poiskForExtencion = new PoiskForExtencion();
            poiskForExtencion.walk( fileExtenxion,checkList);
            if(checkList.isEmpty())  SimpleGUI.files.append("There are not files with this extancion" + "\n");
            checkList.clear();
        } else {
            PoiskForStart poiskForStart = new PoiskForStart();
            poiskForStart.walk(fileExtenxion,checkList);
            if(checkList.isEmpty())  SimpleGUI.files.append("There are not files with this start" + "\n");
            checkList.clear();
        }
    }
}