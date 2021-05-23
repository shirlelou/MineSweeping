package view;

import javax.swing.*;
import java.awt.*;

public class HelpComponent extends JPanel{

    public JButton music;
    public JButton rets;

    @Override

    public void paintComponent(Graphics g) {
        ImageIcon background=new ImageIcon("src\\view\\pictures\\background02.jpg");

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


        JLabel storyText[] = new JLabel[22];
        String[] text = new String[22];
        String text0 ="游戏介绍：";
        String text1 ="本游戏是一款积分制扫雷游戏，关于雷盘的基本操作如下：";
        String text2 ="1.左键单击：点击雷盘某一格，进行开格子。";
        String text3 ="2.右键单击：点击雷盘某一未揭示处，进行插旗。";
        String text4 ="该游戏的规则如下：";
        String text5 ="1.左键：点击雷盘某格，若触雷则扣除当前玩家1分。";
        String text6 ="2.右键：标记雷盘某格，若该格为雷则给标记者加1分并插旗，";
        String text7 ="       如果不是则进行开格子并给标记者加1次失误。";
        String text8 ="胜利条件：所有雷被揭示或标记后，积分高者获胜；";
        String text9 ="        若积分相同，则失误数少者获胜；";
        String text10 ="       若积分和失误数均一致，则判定为平局。";
        String text11 ="";
        String text12 ="相关人物：(游戏内左键单击人物头像可释放主动技能)";
        String text13 ="白银御行：秀知园学院的学生会会长，成绩名列前茅。";
        String text14 ="  独有技能：认真模式(主动)---本回合内得分翻倍.";
        String text15 ="四宫辉夜：秀知园学院的学生会副会长，辅佐会长。";
        String text16 ="  独有技能：预先准备(主动)---本回合内，你的剩余行动数+3.";
        String text17 ="藤原千花：秀知园学院的学生会秘书，是地球之癌(划去)。";
        String text18 ="  独有技能：合理作弊(主动)---你的积分+3，失误数+5.";
        String text19 ="石上优：秀知园学院的学生会会计，精通电脑，朋友很少(划去)。";
        String text20 ="  独有技能：石上真男人(主动)---跳过本回合.";
        String text21 ="Tips：主动技能一局游戏内只能释放一次。";
        for (int i = 0; i < 22; i++) {
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
            }else if (i==11){
                text[i]=text11;
            }else if (i==12){
                text[i]=text12;
            }else if (i==13){
                text[i]=text13;
            }else if (i==14){
                text[i]=text14;
            }else if (i==15){
                text[i]=text15;
            }else if (i==16){
                text[i]=text16;
            }else if (i==17){
                text[i]=text17;
            }else if (i==18){
                text[i]=text18;
            }else if (i==19){
                text[i]=text19;
            }else if (i==20){
                text[i]=text20;
            }else if (i==21){
                text[i]=text21;
            }
        }

        for (int i = 0; i < 22; i++) {
            storyText[i] = new JLabel();
            storyText[i].setBounds(50,-200+i*20,900,600);
            Font font = new Font("黑体",Font.BOLD,20);
            storyText[i].setFont(font);
            storyText[i].setText(text[i]);
            add(storyText[i]);
        }
    }
    
}
