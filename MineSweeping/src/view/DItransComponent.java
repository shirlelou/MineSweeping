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
    JTextField setMoveNum;

    @Override

        public void paintComponent(Graphics g) {
            ImageIcon background=new ImageIcon("src\\view\\pictures\\background02.jpg");

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
        setMoveNum = new JTextField();
        comfirm = new JButton("确定");
        JLabel Rows = new JLabel("输入行数");
        JLabel Cols = new JLabel("输入列数");
        JLabel MineNum = new JLabel("输入地雷数");
        JLabel PlayerNum = new JLabel("输入玩家数");
        JLabel SetMoveNum = new JLabel("输入行动数");

        Font font = new Font("黑体",Font.BOLD,20);
        Rows.setFont(font);
        Cols.setFont(font);
        MineNum.setFont(font);
        PlayerNum.setFont(font);
        SetMoveNum.setFont(font);

        Rows.setBounds(250,370,110,30);
        Cols.setBounds(370,370,110,30);
        MineNum.setBounds(490,370,110,30);
        PlayerNum.setBounds(610,370,110,30);
        SetMoveNum.setBounds(730,370,110,30);

        add(Rows);
        add(Cols);
        add(MineNum);
        add(PlayerNum);
        add(SetMoveNum);


        setRows.setFont(font);
        setCols.setFont(font);
        setMineNum.setFont(font);
        setPlayerNum.setFont(font);
        setMoveNum.setFont(font);
        comfirm.setFont(font);

        setRows.setBounds(250,400,110,30);
        setCols.setBounds(370,400,110,30);
        setMineNum.setBounds(490,400,110,30);
        setPlayerNum.setBounds(610,400,110,30);
        setMoveNum.setBounds(730,400,110,30);
        comfirm.setBounds(640,500,100,30);

        add(setRows);
        add(setCols);
        add(setMineNum);
        add(setPlayerNum);
        add(setMoveNum);
        add(comfirm);
    }
}