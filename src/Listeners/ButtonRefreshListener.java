package Listeners;

import SimpleGUI.SimpleGUI;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonRefreshListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        SimpleGUI.files.setText(null);
    }
}
