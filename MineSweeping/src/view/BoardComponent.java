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



    public BoardComponent(int row,int col,int playerNum,int aiNum,int mineNum,int moveNum){

        setLayout(null);

        Image retsicon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon returnicon = new ImageIcon(retsicon);


        rets = new JButton(returnicon);
        rets.setBounds(0,0,50,50);
        rets.setBorderPainted(false);
        add(rets);


        setSize(990,805);
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
        for (int i = 1; i <= this.rows; i++) {
            for (int j = 1; j <= this.cols; j++) {
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean[][] ret=new boolean[rows+1][cols+1];
                        for (int k = 1; k < rows+1; k++) {
                            for (int l = 1; l < cols+1; l++) {
                                ret[k][l]=false;
                            }
                        }
                        if (e.getButton() == MouseEvent.BUTTON1){
                            if (board.getOpenState(finalI,finalJ)==1||board.getOpenState(finalI,finalJ)==0){

                                board.operate(finalI, finalJ,true,ret);

                                for(int x=1;x<=rows;x++){
                                    for(int y=1;y<=cols;y++){
                                        if(ret[x][y]){
                                            if(board.getMineState(x,y)==9){
                                                Image Mine = new ImageIcon("src\\view\\pictures\\mine.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon mine = new ImageIcon(Mine);
                                                buttons[x][y].setIcon(mine);
                                            }
                                            else if(board.getMineState(x,y)==0){
                                                Image Open = new ImageIcon("src\\view\\pictures\\blankOpen.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }else if(board.getMineState(x,y)==1){
                                                Image Open = new ImageIcon("src\\view\\pictures\\1.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }else if(board.getMineState(x,y)==2){
                                                Image Open = new ImageIcon("src\\view\\pictures\\2.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }else if(board.getMineState(x,y)==3){
                                                Image Open = new ImageIcon("src\\view\\pictures\\3.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }else if(board.getMineState(x,y)==4){
                                                Image Open = new ImageIcon("src\\view\\pictures\\4.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }else if(board.getMineState(x,y)==5){
                                                Image Open = new ImageIcon("src\\view\\pictures\\5.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }else if(board.getMineState(x,y)==6){
                                                Image Open = new ImageIcon("src\\view\\pictures\\6.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }else if(board.getMineState(x,y)==7){
                                                Image Open = new ImageIcon("src\\view\\pictures\\7.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }else if(board.getMineState(x,y)==8){
                                                Image Open = new ImageIcon("src\\view\\pictures\\8.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }
                                        }

                                    }
                                }
                            }

                        }
                        if (e.getButton() == MouseEvent.BUTTON3){
                            if (board.getOpenState(finalI,finalJ)==1){
                                board.operate(finalI, finalJ,false,ret);

                                for(int x=1;x<=rows;x++) {
                                    for (int y = 1; y <= cols; y++) {
                                        if (ret[x][y]) {
                                            if (board.getMineState(x, y) == 9) {
                                                Image Flag = new ImageIcon("src\\view\\pictures\\flag.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon flag = new ImageIcon(Flag);
                                                buttons[x][y].setIcon(flag);
                                            } else if (board.getMineState(x, y) == 0) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\blankOpen.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            } else if (board.getMineState(x, y) == 1) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\1.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            } else if (board.getMineState(x, y) == 2) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\2.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            } else if (board.getMineState(x, y) == 3) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\3.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            } else if (board.getMineState(x, y) == 4) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\4.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            } else if (board.getMineState(x, y) == 5) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\5.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            } else if (board.getMineState(x, y) == 6) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\6.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            } else if (board.getMineState(x, y) == 7) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\7.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            } else if (board.getMineState(x, y) == 8) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\8.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }


}

