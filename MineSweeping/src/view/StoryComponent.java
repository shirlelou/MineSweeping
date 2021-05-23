package view;

import javax.swing.*;
import java.awt.*;

public class StoryComponent extends JPanel {

    public JButton music;
    public JButton rets;

    @Override

        public void paintComponent(Graphics g) {
            ImageIcon background=new ImageIcon("src\\view\\pictures\\background02.jpg");

            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);

        }

    public StoryComponent(){
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


        JLabel storyText[] = new JLabel[11];
        String[] text = new String[11];
        String text0 ="藤原千花：电竞社自制了一个新的扫雷游戏拜托我来测试噢~（辉夜、御行：（盯））";
        String text1 ="石上优：诶，居然是自制的么。";
        String text2 ="藤原千花：那当然~这可是积分制的扫雷~大家一起来玩吧！";
        String text3 ="四宫辉夜/白银御行：不要。（详情参考上次大富翁）";
        String text4 ="藤原千花：诶~为甚么。来玩嘛来玩嘛来玩嘛来玩嘛*n";
        String text5 ="白银御行：所以说，藤原书记，你为什么要帮别人测试？";
        String text6 ="藤原千花：欸嘿嘿，其实是我妹妹拜托我帮忙的~";
        String text7 ="白银御行：积分制扫雷么，有意思（内心os：趁此机会或许能击破辉夜的面具！）";
        String text8 ="四宫辉夜：嗯，那我们四个人来测试吧(内心os:在这里，或许能击破会长的防御!)";
        String text9 ="石上优：诶，我也要来么（内心os：啊，我想玩我的游戏机啊~）";
        String text10 ="藤原千花：好！那么，Game Start~";
        for (int i = 0; i < 11; i++) {
            if (i==0){
                text[i]=text0;
            }else if (i==1){
                text[i]=text1;
            }else if (i==2){
                text[i]=text2;
            }else if (i==3){
                text[i]=text3;
            }else if (i==4){
                text[i]=text4;
            }else if (i==5){
                text[i]=text5;
            }else if (i==6){
                text[i]=text6;
            }else if (i==7){
                text[i]=text7;
            }else if (i==8){
                text[i]=text8;
            }else if (i==9){
                text[i]=text9;
            }else if (i==10){
                text[i]=text10;
            }
        }

        for (int i = 0; i < 11; i++) {
            storyText[i] = new JLabel();
            storyText[i].setBounds(50,-100+i*20,800,600);
            Font font = new Font("黑体",Font.BOLD,20);
            storyText[i].setFont(font);
            storyText[i].setText(text[i]);
            add(storyText[i]);
        }




    }
    

}
