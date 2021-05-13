package view;

import javax.swing.*;
import java.awt.*;

public class StoryComponent extends JPanel {

    public JButton music;
    public JButton rets;

    @Override

        public void paintComponent(Graphics g) {
            ImageIcon background=new ImageIcon("");

            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);

        }

    public StoryComponent(){
        setSize(818,805);
        setLayout(null);

        Image icon = new ImageIcon("src\\view\\pictures\\musicicon.gif").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon musicicon = new ImageIcon(icon);
        music = new JButton(musicicon);
        music.setBounds(758,725,50,50);
        music.setBorderPainted(false);
        add(music);

        Image retsicon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon returnicon = new ImageIcon(retsicon);
        rets = new JButton(returnicon);
        rets.setBounds(0,0,50,50);
        rets.setBorderPainted(false);
        add(rets);
    }
    

}
