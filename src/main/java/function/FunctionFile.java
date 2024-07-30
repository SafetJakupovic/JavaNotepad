package function;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import main.GUI;

/**
 * FunctionFile
 */
public class FunctionFile {
  GUI gui;
  String fileName;
  String filePath;

  public FunctionFile(GUI gui) {
    this.gui = gui;
  }

  public void newFile() {
    gui.textArea.setText("");
    gui.window.setTitle("New");
  }

  public void openFile() {
    FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
    fd.setVisible(true);

    // if something was chosen from the file dialog
    if (fd.getFile() != null) {
      fileName = fd.getFile();
      filePath = fd.getDirectory();
      gui.window.setTitle(fileName);
    }

    try {
      BufferedReader br = new BufferedReader(new FileReader(filePath + fileName));
      gui.textArea.setText(""); // first empty out the text area
      String line;
      while ((line = br.readLine()) != null) {
        gui.textArea.append(line + "\n");
      }
      br.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
