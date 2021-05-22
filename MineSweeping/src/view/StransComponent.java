package view;

import javax.swing.*;
import java.awt.*;


public class StransComponent extends JPanel{
        
    public JButton music;
    public JButton rets;

    public JButton primary;
    public JButton middle;
    public JButton advance;
    public JButton DIY;
    



    @Override

        public void paintComponent(Graphics g) {
            ImageIcon background=new ImageIcon("src\\view\\pictures\\background.gif");

            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);

        }

    public StransComponent(){

        setSize(990,805);

        Image icon = new ImageIcon("src\\view\\pictures\\musicicon.gif").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon musicicon = new ImageIcon(icon);
        primary = new JButton("初级");
        middle = new JButton("中级");
        advance = new JButton("高级");
        DIY = new JButton("自定义");
        music = new JButton(musicicon);

        Image retsicon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon returnicon = new ImageIcon(retsicon);
        rets = new JButton(returnicon);
        rets.setBounds(0,0,50,50);
        rets.setBorderPainted(false);
        add(rets);

        setLayout(null);
        primary.setBounds(230,350,350,50);
        advance.setBounds(230,550,350,50);
        middle.setBounds(230,450,350,50);
        DIY.setBounds(230,650,350,50);
        music.setBounds(758,725,50,50);


        music.setBorderPainted(false);
       

        add(primary);
        add(middle);
        add(advance);
        add(DIY);
        add(music);
        
    }
}