package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame{

    
    public void setContentPane(StartComponent start) {
        getRootPane().setContentPane(start);
    }
    public void setContentPane(TransComponent trans) {
        getRootPane().setContentPane(trans);
    }


    public GameFrame() {
        Image icon = new ImageIcon("src\\view\\pictures\\Icon.gif").getImage();
        setTitle("扫雷游戏");
        setIconImage(icon);
        
        setSize(818, 815);
        
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        StartComponent start = new StartComponent();
        TransComponent trans = new TransComponent();

        start.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(trans);
            }
        });
        trans.ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(start);
            }
        });

        setContentPane(start);
        

    }
}
