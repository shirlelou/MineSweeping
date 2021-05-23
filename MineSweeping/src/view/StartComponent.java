package view;

import javax.swing.*;
import java.awt.*;


public class StartComponent extends JPanel{
        
    public JButton music;


    public JButton start;
    public JButton story;
    public JButton help;
    



    @Override

        public void paintComponent(Graphics g) {
            ImageIcon background=new ImageIcon("src\\view\\pictures\\background.gif");

            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);

        }

    public StartComponent(){

        setSize(990,805);

        Image icon = new ImageIcon("src\\view\\pictures\\musicicon.gif").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon musicicon = new ImageIcon(icon);
        start = new JButton("开始游戏");
        story = new JButton("故事");
        help = new JButton("帮助");
        music = new JButton(musicicon);

        setLayout(null);
        start.setBounds(230,350,350,50);
        help.setBounds(230,550,350,50);
        story.setBounds(230,450,350,50);
        music.setBounds(758,725,50,50);

        
        start.setContentAreaFilled(false);
        help.setContentAreaFilled(false);
        story.setContentAreaFilled(false);

        start.setForeground(Color.yellow);
        help.setForeground(Color.yellow);
        story.setForeground(Color.yellow);


        music.setBorderPainted(false);
       

        add(start);
        add(story);
        add(help);
        add(music);


        
        
    }
}
