package view;

import javax.swing.*;
import java.awt.*;

public class HelpComponent extends JPanel{

    public JButton music;
    public JButton rets;

    @Override

    public void paintComponent(Graphics g) {
        ImageIcon background=new ImageIcon("");

        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);

    }

    public HelpComponent(){
        setSize(990,805);
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


        JLabel storyText = new JLabel();
        storyText.setBounds(100,100,600,600);
        Font font = new Font("黑体",Font.BOLD,12);
        storyText.setFont(font);
        String text0 = "";
        String text1 = "";
        String text2 = "";
        String text3 = "";
        storyText.setText(text0+text1+text2+text3);
        add(storyText);
    }
    
}
