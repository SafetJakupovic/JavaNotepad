package main;

import function.FunctionFile;
import function.FunctionFormat;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class GUI implements ActionListener {
  public JFrame window;
  // TEXT AREA
  public JTextArea textArea;
  public boolean wordWrap = false;
  JScrollPane scrollPane;
  // TOP MENU BAR
  JMenuBar menuBar;
  JMenu menuFile, menuEdit, menuFormat, menuColor;
  // FILE MENU
  JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
  // FORMAT MENU
  public JMenuItem iWordWrap;
  JMenu menuFont, menuFontSize;
  JMenuItem iFontArial, iFontComicSans, iFontTimesNewRoman;
  JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24,
      iFontSize28;

  FunctionFile file = new FunctionFile(this);
  FunctionFormat format = new FunctionFormat(this);

  public static void main(String[] args) {
    new GUI();
  }

  public GUI() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    createWindow();
    createTextArea();
    createMenuBar();
    createFileItem();
    createFormatMenu();
    format.selectedFont = "Monospaced";
    format.createFont(16);
    window.setVisible(true);
  }

  public void createWindow() {
    window = new JFrame("Notepad");
    window.setSize(800, 600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void createTextArea() {
    textArea = new JTextArea();
    scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    window.add(scrollPane);
  }

  public void createMenuBar() {
    menuBar = new JMenuBar();
    window.setJMenuBar(menuBar);

    menuFile = new JMenu("File");
    menuBar.add(menuFile);
    menuEdit = new JMenu("Edit");
    menuBar.add(menuEdit);
    menuFormat = new JMenu("Format");
    menuBar.add(menuFormat);
    menuColor = new JMenu("Color");
    menuBar.add(menuColor);
  }

  public void createFileItem() {
    iNew = new JMenuItem("New");
    iNew.addActionListener(this);
    iNew.setActionCommand("New");
    menuFile.add(iNew);

    iOpen = new JMenuItem("Open");
    iOpen.addActionListener(this);
    iOpen.setActionCommand("Open");
    menuFile.add(iOpen);

    iSave = new JMenuItem("Save");
    iSave.addActionListener(this);
    iSave.setActionCommand("Save");
    menuFile.add(iSave);

    iSaveAs = new JMenuItem("Save As");
    iSaveAs.addActionListener(this);
    iSaveAs.setActionCommand("SaveAs");
    menuFile.add(iSaveAs);

    iExit = new JMenuItem("Exit");
    iExit.addActionListener(this);
    iExit.setActionCommand("Exit");
    menuFile.add(iExit);
  }

  public void createFormatMenu() {
    iWordWrap = new JMenuItem("Word Wrap: Off");
    iWordWrap.addActionListener(this);
    iWordWrap.setActionCommand("WordWrap");
    menuFormat.add(iWordWrap);

    menuFont = new JMenu("Font");
    menuFormat.add(menuFont);

    iFontArial = new JMenuItem("Arial");
    iFontArial.addActionListener(this);
    iFontArial.setActionCommand("Arial");
    menuFont.add(iFontArial);

    iFontComicSans = new JMenuItem("Comic Sans MS");
    iFontComicSans.addActionListener(this);
    iFontComicSans.setActionCommand("Comic Sans MS");
    menuFont.add(iFontComicSans);

    iFontTimesNewRoman = new JMenuItem("Times New Roman");
    iFontTimesNewRoman.addActionListener(this);
    iFontTimesNewRoman.setActionCommand("Times New Roman");
    menuFont.add(iFontTimesNewRoman);

    menuFontSize = new JMenu("Font Size");
    menuFormat.add(menuFontSize);

    iFontSize8 = new JMenuItem("8");
    iFontSize8.addActionListener(this);
    iFontSize8.setActionCommand("size8");
    menuFontSize.add(iFontSize8);

    iFontSize12 = new JMenuItem("12");
    iFontSize12.addActionListener(this);
    iFontSize12.setActionCommand("size12");
    menuFontSize.add(iFontSize12);

    iFontSize16 = new JMenuItem("16");
    iFontSize16.addActionListener(this);
    iFontSize16.setActionCommand("size16");
    menuFontSize.add(iFontSize16);

    iFontSize20 = new JMenuItem("20");
    iFontSize20.addActionListener(this);
    iFontSize20.setActionCommand("size20");
    menuFontSize.add(iFontSize20);

    iFontSize24 = new JMenuItem("24");
    iFontSize24.addActionListener(this);
    iFontSize24.setActionCommand("size24");
    menuFontSize.add(iFontSize24);

    iFontSize28 = new JMenuItem("28");
    iFontSize28.addActionListener(this);
    iFontSize28.setActionCommand("size28");
    menuFontSize.add(iFontSize28);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    switch (command) {
      case "New":
        file.newFile();
        break;
      case "Open":
        file.openFile();
        break;
      case "Save":
        file.saveFile();
        break;
      case "SaveAs":
        file.saveAsFile();
        break;
      case "Exit":
        file.Exit();
        break;

      case "WordWrap":
        format.wordWrap();
        break;
      case "Arial":
        format.setFont(command);
        break;
      case "ComicSans":
        format.setFont(command);
        break;
      case "TimesNewRoman":
        format.setFont(command);
        break;
      case "size8":
        format.createFont(8);
        break;
      case "size12":
        format.createFont(12);
        break;
      case "size16":
        format.createFont(16);
        break;
      case "size20":
        format.createFont(20);
        break;
      case "size24":
        format.createFont(24);
        break;
      case "size28":
        format.createFont(28);
        break;
      default:
        break;
    }
  }
}
