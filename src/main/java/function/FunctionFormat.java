package function;

import java.awt.Font;
import main.GUI;

/**
 * FunctionFormat
 */
public class FunctionFormat {

  GUI gui;
  Font arial, comicSans, timesNewRoman;
  public String selectedFont;

  public FunctionFormat(GUI gui) {
    this.gui = gui;
  }

  public void wordWrap() {
    if (!gui.wordWrap) {
      gui.wordWrap = true;
      gui.textArea.setLineWrap(true);
      gui.textArea.setWrapStyleWord(true);
      gui.iWordWrap.setText("Word Wrap: On");
    } else {
      gui.wordWrap = false;
      gui.textArea.setLineWrap(false);
      gui.textArea.setWrapStyleWord(false);
      gui.iWordWrap.setText("Word Wrap: Off");
    }
  }

  public void createFont(int fontSize) {
    // make sure you have the appropriate fonts installed
    arial = new Font("Arial", Font.PLAIN, fontSize);
    comicSans = new Font("Comic Sans MS", Font.PLAIN, fontSize);
    timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
    setFont(selectedFont);
  }

  public void setFont(String font) {
    selectedFont = font;
    switch (selectedFont) {
      case "Arial":
        gui.textArea.setFont(arial);
        break;
      case "ComicSans":
        gui.textArea.setFont(comicSans);
        break;
      case "TimesNewRoman":
        gui.textArea.setFont(timesNewRoman);
        break;
      default:
        break;
    }
  }
}
