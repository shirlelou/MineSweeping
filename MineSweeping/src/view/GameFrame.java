package view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    public GameFrame() {
        Image icon = new ImageIcon("MineSweeping\\src\\view\\pictures\\Icon.gif").getImage();
        setTitle("扫雷游戏");
        setIconImage(icon);
        setSize(818, 600);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
    }
}
