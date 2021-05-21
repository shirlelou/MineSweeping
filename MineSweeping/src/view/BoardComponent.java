package view;

import model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BoardComponent extends JPanel {

    JButton rets;

    private int rows;
    private int cols;
    private int bombCount;
    private int playerNum;
    private int AINum;
    private int moveNum;
    private JButton[][] buttons;
    private SUMember[] suMembers;
    private GameBoard gameBoard;
    private Board board;

    @Override

    public void paintComponent(Graphics g) {
        ImageIcon background=new ImageIcon("src\\view\\pictures\\background.gif");

        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);

    }


    public BoardComponent(int row,int col,int playerNum,int aiNum,int mineNum,int moveNum){

        setLayout(null);

        Image retsicon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon returnicon = new ImageIcon(retsicon);
        rets = new JButton(returnicon);
        rets.setBounds(0,0,50,50);
        rets.setBorderPainted(false);
        add(rets);


        setSize(818,805);
        rows = row;
        cols = col;
        bombCount = mineNum;

        this.playerNum=playerNum;
        AINum=aiNum;
        this.moveNum=moveNum;
        gameBoard = new GameBoard(rows,cols);
        buttons = gameBoard.getButtons();
        board = new Board(rows,cols,playerNum,aiNum,mineNum,moveNum);
        suMembers=new SUMember[playerNum+AINum+1];


        for(int i=1;i<=playerNum+AINum;i++){
            suMembers[i]=new SUMember(i);
            if(i==1){
                suMembers[i].setBounds(50,9,160,190);
            }
            if(i==2){
                suMembers[i].setBounds(50,208,160,190);
            }
            if(i==3){
                suMembers[i].setBounds(50,407,160,190);
            }
            if(i==4){
                suMembers[i].setBounds(50,606,160,190);
            }
            add(suMembers[i]);
        }
        JLabel mapData = new JLabel();
        initButtonClick();
        gameBoard.setButtons(buttons);
        add(gameBoard);
    }

    public void initButtonClick(){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean[][] ret=new boolean[rows+1][cols+1];
                        if (e.getButton() == MouseEvent.BUTTON1){

                            board.operate(finalI, finalJ,true,ret);

                            for(int x=1;x<=rows;x++){
                                for(int y=1;y<=cols;y++){
                                    if(ret[x][y]){
                                        if(board.getMineState(x,y)==9){
                                            Image icon = new ImageIcon("src\\view\\pictures\\musicicon.gif").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
                                            ImageIcon musicicon = new ImageIcon(icon);
                                            buttons[x][y].setIcon(musicicon);
                                        }
                                        else if(board.getMineState(x,y)==0){
                                            buttons[x][y].setVisible(false);
                                        }
                                    }
                                }
                            }
                        }
                        if (e.getButton() == MouseEvent.BUTTON3){
                            board.operate(finalI, finalJ,false,ret);
                        }
                    }
                });
            }
        }
    }


}

