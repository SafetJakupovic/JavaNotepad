package function;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GUI;

/**
 * KeyHandler
 */
public class KeyHandler implements KeyListener {
  GUI gui;

  public KeyHandler(GUI gui) { this.gui = gui; }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S)
      gui.file.saveFile();

    if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z)
      gui.edit.undo();
    if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_R)
      gui.edit.redo();

    if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F)
      gui.menuFile.doClick();
  }

  @Override
  public void keyReleased(KeyEvent e) {}
}
