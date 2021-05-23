package view;

import javax.swing.*;
import java.awt.*;


public class TransComponent extends JPanel{
        
    public JButton music;
    public JButton rets;

    
    public JButton one;
    public JButton two;
    public JButton many;
    public JButton diy;
    




    @Override

        public void paintComponent(Graphics g) {
            ImageIcon background=new ImageIcon("src\\view\\pictures\\background.gif");

            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);

        }

    public TransComponent(){

        

        setSize(990,805);

        Image icon = new ImageIcon("src\\view\\pictures\\musicicon.gif").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon musicicon = new ImageIcon(icon);
        music = new JButton(musicicon);
        music.setBounds(758,725,50,50);
        music.setBorderPainted(false);
        add(music);

        Image reticon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon returnicon = new ImageIcon(reticon);
        rets = new JButton(returnicon);
        rets.setBounds(0,0,50,50);
        rets.setBorderPainted(false);
        add(rets);


        
        one = new JButton("单人游戏");
        two = new JButton("双人游戏");
        many = new JButton("多人游戏");
        diy = new JButton("自定义");
        
        

        setLayout(null);
        
        one.setBounds(230,350,350,50);
        two.setBounds(230,450,350,50);
        many.setBounds(230,550,350,50);
        diy.setBounds(230,650,350,50);
        


       
        
        add(one);
        add(two);
        add(many);
        add(diy);
        
        
        setOpaque(true);

    }
}
