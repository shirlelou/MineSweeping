import javax.swing.*;
import java.awt.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);       
        });
    }
}
