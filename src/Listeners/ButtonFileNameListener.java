package Listeners;

import FileManager.FileCollecction;
import SimpleGUI.SimpleGUI;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonFileNameListener extends Component implements ActionListener {
    FileCollecction fileCollecction;

    public ButtonFileNameListener(FileCollecction fileCollecction) {
        this.fileCollecction = fileCollecction;
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Select file for indexation");

        if (chooser.showDialog(this, "Index") == JFileChooser.APPROVE_OPTION) {
            SimpleGUI.labelFileName.setText(chooser.getSelectedFile().getAbsolutePath());
            FileCollecction.fileColection.clear();
            fileCollecction.nameDirectory = chooser.getSelectedFile().getAbsolutePath();
            fileCollecction.zapolnCollection(chooser.getSelectedFile().getAbsolutePath());
        }
    }
}
