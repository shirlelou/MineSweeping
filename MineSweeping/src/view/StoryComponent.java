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


        JLabel storyText = new JLabel();
        storyText.setBounds(100,100,600,600);
        Font font = new Font("黑体",Font.BOLD,12);
        storyText.setFont(font);
        String text0 = "藤原千花：电竞社自制了一个新的扫雷游戏拜托我来测试噢~（辉夜、御行、石上：（盯））\n"+
                "石上优：诶，居然是自制的么。\n" +
                "藤原千花：那当然~这可是积分制的扫雷~\n";
        String text1 = "白银御行：所以说，藤原书记，你为什么要帮别人测试？\n"+
                "藤原千花：欸嘿嘿，其实是我妹妹拜托我帮忙的~\n";
        String text2 = "白银御行：积分制扫雷么，有意思（内心os：趁此机会或许能击破辉夜的面具！）\n"+
                "四宫辉夜：嗯，听起来还不错，那我们四个人来测试吧（内心os：用这个游戏，或许能击破会长的防御！）\n";
        String text3 = "石上优：诶，我也要来么（内心os：啊，我想玩我的游戏机啊~）\n"+
                "藤原千花：好！那么，Game Start~";
        storyText.setText(text0+text1+text2+text3);
        add(storyText);
    }
    

}
