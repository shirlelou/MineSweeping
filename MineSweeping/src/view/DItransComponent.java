package view;

import javax.swing.*;
import java.awt.*;


public class DItransComponent extends JPanel{
        
    public JButton music;
    public JButton rets;
    public JButton comfirm;

    JTextField setRows;
    JTextField setCols;
    JTextField setMineNum;
    JTextField setPlayerNum;

    @Override

        public void paintComponent(Graphics g) {
            ImageIcon background=new ImageIcon("");

            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);

        }

    public DItransComponent(){

        setSize(990,805);

        Image icon = new ImageIcon("src\\view\\pictures\\musicicon.gif").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon musicicon = new ImageIcon(icon);
        music = new JButton(musicicon);

        Image retsicon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon returnicon = new ImageIcon(retsicon);
        rets = new JButton(returnicon);
        rets.setBounds(0,0,50,50);
        rets.setBorderPainted(false);
        add(rets);

        setLayout(null);
        music.setBounds(930,725,50,50);


        music.setBorderPainted(false);
       
        add(music);

        setRows = new JTextField();
        setCols = new JTextField();
        setMineNum = new JTextField();
        setPlayerNum = new JTextField();
        comfirm = new JButton("确定");
        JLabel Rows = new JLabel("输入行数");
        JLabel Cols = new JLabel("输入列数");
        JLabel MineNum = new JLabel("输入地雷数");
        JLabel PlayerNum = new JLabel("输入玩家数");
         

        Font font = new Font("黑体",Font.BOLD,10);
        Rows.setFont(font);
        Cols.setFont(font);
        MineNum.setFont(font);
        PlayerNum.setFont(font);
        Rows.setBounds(425,380,40,10);
        Cols.setBounds(455,380,40,10);
        MineNum.setBounds(510,380,50,10);
        PlayerNum.setBounds(540,380,50,10);
        comfirm.setBounds(540,500,50,10);
        add(Rows);
        add(Cols);
        add(MineNum);
        add(PlayerNum);
        add(comfirm);

        setRows.setFont(font);
        setCols.setFont(font);
        setMineNum.setFont(font);
        setPlayerNum.setFont(font);
        setRows.setBounds(430,400,30,10);
        setCols.setBounds(460,400,30,10);
        setMineNum.setBounds(515,400,40,10);
        setPlayerNum.setBounds(550,400,30,10);
        add(setRows);
        add(setCols);
        add(setMineNum);
        add(setPlayerNum);
    }
}