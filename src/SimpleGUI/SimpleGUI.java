package SimpleGUI;

import FileManager.FileCollecction;
import FileManager.SaverLoaderForFileCollection;
import Listeners.ButtonFileNameListener;
import Listeners.ButtonRefreshListener;
import Listeners.ButtonSearchListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SimpleGUI extends JFrame {
    FileCollecction fileCollecction;
    SaverLoaderForFileCollection saverLoaderForFileCollection = new SaverLoaderForFileCollection();

    private void createMenuBar() {

        var menuBar = new JMenuBar();
        var exitIcon = new ImageIcon("src/resources/exit.png");

        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var eMenuItem = new JMenuItem("Exit", exitIcon);
        var eMenuItem2 = new JMenuItem("Save", exitIcon);
        var eMenuItem3 = new JMenuItem("Load", exitIcon);
        var eMenuItem4 = new JMenuItem("Look", exitIcon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((event) -> System.exit(0));
        eMenuItem2.setMnemonic(KeyEvent.VK_E);
        eMenuItem2.setToolTipText("Save your current file");
        eMenuItem2.addActionListener((event) -> {
            saverLoaderForFileCollection.saver();
        });
        eMenuItem3.setMnemonic(KeyEvent.VK_E);
        eMenuItem3.setToolTipText("Load your last file");
        eMenuItem3.addActionListener((event) -> {
            saverLoaderForFileCollection.loader();
        });
        eMenuItem4.setMnemonic(KeyEvent.VK_E);
        eMenuItem4.setToolTipText("Look fileas in derictories");
        eMenuItem4.addActionListener((event) -> {
            saverLoaderForFileCollection.looker();
        });
        fileMenu.add(eMenuItem4);
        fileMenu.add(eMenuItem2);
        fileMenu.add(eMenuItem3);
        fileMenu.add(eMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    public static JButton fileName = new JButton("Choose file");
    public static JTextField fileExtenxion = new JTextField("", 80);
    public static JLabel labelFileName = new JLabel("File name");
    public JLabel labelFileExtencion = new JLabel("Extencion or start");
    public JLabel labelForButton = new JLabel("Button for search");
    public static JTextArea files = new JTextArea();
    public JButton search = new JButton("Search");
    public JButton refresh = new JButton("Refresh");
    public JRadioButton startWith = new JRadioButton("Start with");
    public static JRadioButton extencion = new JRadioButton("Extencion");

    public SimpleGUI(FileCollecction fileCollecction) {
        super("File manager");
        this.fileCollecction = fileCollecction;
        this.setBounds(300, 150, 800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenuBar();


        Container container = this.getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        // По умолчанию натуральная высота, максимальная ширина
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.weightx = 0.5;
//        constraints.gridy = 0;  // нулевая ячейка таблицы по вертикали


        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.weighty = 0.25;// нулевая ячейка таблицы по горизонтали
        container.add(labelFileName, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridwidth = 1;
//        constraints.weighty = 0.25;// первая ячейка таблицы по горизонтали
        container.add(fileName, constraints);

        ButtonGroup group = new ButtonGroup();
        group.add(startWith);
        group.add(extencion);


        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.weighty = 0.15;
//        constraints.weightx = 0.15;// нулевая ячейка таблицы по горизонтали
        container.add(fileExtenxion, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weighty = 0.15;
        constraints.weightx = 0.1;// первая ячейка таблицы по горизонтали
        container.add(search, constraints);


        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 2;// нулевая ячейка таблицы по горизонтали
        container.add(startWith, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 2;// первая ячейка таблицы по горизонтали
        container.add(extencion, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 120;   // кнопка высокая
        constraints.weightx = 0.0;
        constraints.gridwidth = 4;    // размер кнопки в две ячейки
        constraints.gridx = 0;    // нулевая ячейка по горизонтали
        constraints.gridy = 3;    // первая ячейка по вертикали
        container.add(new JScrollPane(files), constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 0;    // установить первоначальный размер кнопки
        constraints.weighty = 0.1;  // установить отступ
        // установить кнопку в конец окна
       // constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.insets = new Insets(5, 0, 0, 0);  // граница ячейки по Y
        constraints.gridwidth = 1;    // размер кнопки в 2 ячейки
        constraints.gridx = 3;    // первая ячейка таблицы по горизонтали
        constraints.gridy = 4;    // вторая ячейка по вертикали
        container.add(refresh, constraints);
//container.setBackground(Color.gray);
        startWith.setSelected(true);
        search.addActionListener(new ButtonSearchListener());
        refresh.addActionListener(new ButtonRefreshListener());
        fileName.addActionListener(new ButtonFileNameListener(fileCollecction));

    }

}
