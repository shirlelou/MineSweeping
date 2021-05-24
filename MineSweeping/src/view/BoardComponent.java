package view;

import model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
    public Board board;
    private JLabel mapData=new JLabel();
    private JButton cheat;
    private Number cheatNum = new Number();
    private Number skillNum1 = new Number();
    private Number skillNum2 = new Number();
    private Number skillNum3 = new Number();
    private Number skillNum4 = new Number();
    public JButton infile ;


    public BoardComponent(){
        setLayout(null);
        setSize(990,805);

        Image retsicon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(65,65,Image.SCALE_DEFAULT);
        ImageIcon returnicon = new ImageIcon(retsicon);
        rets = new JButton(returnicon);
        rets.setBounds(0,0,50,50);
        rets.setBorderPainted(false);
        add(rets);

        Image cheatt = new ImageIcon("src\\view\\pictures\\cheaticon.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon cheaticon = new ImageIcon(cheatt);
        cheat = new JButton(cheaticon);
        cheat.setBounds(910,10,65,65);
        add(cheat);

    }

    public void setSuMembers(int  playerNum,int aiNum,int moveNum) {
        suMembers=new SUMember[playerNum+AINum+1];
        this.playerNum=playerNum;
        this.moveNum=moveNum;
        AINum=aiNum;
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
    }
    public void setBoard(int rows,int cols,int mineNum){
        this.rows = rows;
        this.cols = cols;
        this.bombCount = mineNum;
        gameBoard = new GameBoard(rows,cols);
        buttons = gameBoard.getButtons();

        board = new Board(rows,cols,playerNum,AINum,mineNum,moveNum);

        infile = new JButton("存档");
        infile.setBounds(300,725,100,50);
        add(infile);

        infile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.inFile();
            }
        });

        add(mapData);
        setMapData();


        initButtonClick();
        gameBoard.setButtons(buttons);
        add(gameBoard);

    }

    public BoardComponent(int row,int col,int playerNum,int aiNum,int mineNum,int moveNum){

        setLayout(null);
        
        Image retsicon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(65,65,Image.SCALE_DEFAULT);
        ImageIcon returnicon = new ImageIcon(retsicon);


        rets = new JButton(returnicon);
        rets.setBounds(0,0,50,50);
        rets.setBorderPainted(false);
        add(rets);


        setSize(990,805);
        rows = row;
        cols = col;
        bombCount = mineNum;

        Image cheatt = new ImageIcon("src\\view\\pictures\\cheaticon.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon cheaticon = new ImageIcon(cheatt);
        cheat = new JButton(cheaticon);
        cheat.setBounds(910,10,65,65);
        add(cheat);

        

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
                skillNum1.i=0;
                suMembers[i].getMemberImage().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (skillNum1.i==0){
                            for (int x = 1; x <= board.row; x++) {
                                boolean jdg = false;
                                for (int y = 1; y <= board.row; y++) {
                                    if (board.getOpenState(x, y) == 1&&board.getMineState(x, y) == 9) {
                                        Image Flag = new ImageIcon("src\\view\\pictures\\flag.jpg").getImage()
                                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                        ImageIcon flag = new ImageIcon(Flag);
                                        buttons[x][y].setIcon(flag);
                                        buttons[x][y].setBorderPainted(false);
                                        board.gridInfo[x][y]=92;
                                        board.getPlayers()[1].setScore(board.getPlayers()[1].getScore()+1);
                                        board.setRemain(board.getRemain()-1);
                                        refreshData();
                                        jdg=true;
                                    }
                                    if (jdg){
                                        break;
                                    }
                                }
                                if (jdg){
                                    skillNum1.i++;
                                    break;
                                }
                            }
                        }

                    }
                });
            }
            if(i==2){
                suMembers[i].setBounds(50,208,160,190);
                skillNum2.i=0;
                suMembers[i].getMemberImage().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (skillNum2.i==0){
                            board.setMove(board.getMove()-2);
                            refreshData();
                            skillNum2.i++;
                        }
                    }
                });
            }
            if(i==3){
                suMembers[i].setBounds(50,407,160,190);
                skillNum3.i=0;
                suMembers[i].getMemberImage().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (skillNum3.i==0){
                            board.getPlayers()[3].setScore(board.getPlayers()[3].getScore()+2);
                            board.getPlayers()[3].setMiss(board.getPlayers()[3].getMiss()+5);
                            refreshData();
                            skillNum3.i++;
                        }
                    }
                });
            }
            if(i==4){
                suMembers[i].setBounds(50,606,160,190);
                skillNum4.i=0;
                suMembers[i].getMemberImage().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (skillNum4.i==0){
                            board.setPlayerNow(4);
                            board.setMove(moveNum-1);
                            refreshData();
                            skillNum4.i++;
                        }
                    }
                });
            }
            add(suMembers[i]);
        }

        add(mapData);
        setMapData();

        
        initButtonClick();
        gameBoard.setButtons(buttons);
        add(gameBoard);


        
        
    }


   


    public void setMapData(){
        if (playerNum+AINum==1){
            mapData.setBounds(300,50,500,50);
            Font font = new Font("黑体",Font.BOLD,20);
            mapData.setFont(font);
            String MapData = "当前玩家:"+suMembers[board.getPlayerNow()].getName(board.getPlayerNow())+
                    " 剩余雷数:"+board.getRemain();
            mapData.setText(MapData);
        }else {
            mapData.setBounds(300,50,500,50);
            Font font = new Font("黑体",Font.BOLD,20);
            mapData.setFont(font);
            String MapData = "当前玩家:"+suMembers[board.getPlayerNow()].getName(board.getPlayerNow())+
                    " 剩余雷数:"+board.getRemain()+
                    " 剩余行动数:"+ (moveNum-board.getMove());
            mapData.setText(MapData);
        }
    }

    public void refreshData(){
        for (int x = 1; x <= board.row; x++) {
            for (int y = 1; y <= board.row; y++) {
                if (true) {
                    if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 9) {
                        Image Mine = new ImageIcon("src\\view\\pictures\\mine.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon mine = new ImageIcon(Mine);
                        buttons[x][y].setIcon(mine);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 0) {
                        Image Open = new ImageIcon("src\\view\\pictures\\blankOpen.jpg")
                                .getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 1) {
                        Image Open = new ImageIcon("src\\view\\pictures\\1.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 2) {
                        Image Open = new ImageIcon("src\\view\\pictures\\2.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 3) {
                        Image Open = new ImageIcon("src\\view\\pictures\\3.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 4) {
                        Image Open = new ImageIcon("src\\view\\pictures\\4.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 5) {
                        Image Open = new ImageIcon("src\\view\\pictures\\5.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 6) {
                        Image Open = new ImageIcon("src\\view\\pictures\\6.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 7) {
                        Image Open = new ImageIcon("src\\view\\pictures\\7.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if (board.getOpenState(x, y) == 3&&board.getMineState(x, y) == 8) {
                        Image Open = new ImageIcon("src\\view\\pictures\\8.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon open = new ImageIcon(Open);
                        buttons[x][y].setIcon(open);
                        buttons[x][y].setBorderPainted(false);
                    } else if(board.getOpenState(x, y) == 1){
                        Image Blank = new ImageIcon("src\\view\\pictures\\blankClosed.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon blank = new ImageIcon(Blank);
                        buttons[x][y].setIcon(blank);
                        buttons[x][y].setBorderPainted(false);
                    }
                    else if(board.getOpenState(x, y) == 2&&board.getMineState(x, y) == 9){
                        Image Flag = new ImageIcon("src\\view\\pictures\\flag.jpg").getImage()
                                .getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                        ImageIcon flag = new ImageIcon(Flag);
                        buttons[x][y].setIcon(flag);
                        buttons[x][y].setBorderPainted(false);
                    }
                }
            }
        }


        int now = board.getPlayerNow();
        if (playerNum+AINum==1){
            String MapData = "当前玩家:"+suMembers[now].getName(now)+
                    " 剩余雷数:"+board.getRemain();
            mapData.setText(MapData);
        }else {
            String MapData = "当前玩家:"+suMembers[now].getName(now)+
                    " 剩余雷数:"+board.getRemain()+
                    " 剩余行动数:"+ (moveNum-board.getMove());
            mapData.setText(MapData);
        }

        Image PictureD1 = new ImageIcon("src\\view\\individuation\\member01Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon pictureD1 = new ImageIcon(PictureD1);
        Image PictureD2 = new ImageIcon("src\\view\\individuation\\member02Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon pictureD2 = new ImageIcon(PictureD2);
        Image PictureD3 = new ImageIcon("src\\view\\individuation\\member03Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon pictureD3 = new ImageIcon(PictureD3);
        Image PictureD4 = new ImageIcon("src\\view\\individuation\\member04Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon pictureD4 = new ImageIcon(PictureD4);
        Image Picture1 = new ImageIcon("src\\view\\individuation\\member01.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon picture1 = new ImageIcon(Picture1);
        Image Picture2 = new ImageIcon("src\\view\\individuation\\member02.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon picture2 = new ImageIcon(Picture2);
        Image Picture3 = new ImageIcon("src\\view\\individuation\\member03.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon picture3 = new ImageIcon(Picture3);
        Image Picture4 = new ImageIcon("src\\view\\individuation\\member04.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon picture4 = new ImageIcon(Picture4);
        for (int i = 1; i <= playerNum+AINum; i++) {
            if (i==1){
                suMembers[i].setMemberImage(pictureD1);
                if (i==now){
                    suMembers[i].setMemberImage(picture1);
                }
            }else if (i==2){
                suMembers[i].setMemberImage(pictureD2);
                if (i==now){
                    suMembers[i].setMemberImage(picture2);
                }
            }else if (i==3){
                suMembers[i].setMemberImage(pictureD3);
                if (i==now){
                    suMembers[i].setMemberImage(picture3);
                }
            }else if (i==4){
                suMembers[i].setMemberImage(pictureD4);
                if (i==now){
                    suMembers[i].setMemberImage(picture4);
                }
            }
            String memberData = suMembers[i].getName(i)+" 得分:"+board.getPlayers()[i].getScore()+"失误:"+board.getPlayers()[i].getMiss();
            suMembers[i].scoreBoard.setText(memberData);
        }
    }




    public void initButtonClick(){
        for (int i = 1; i <= this.rows; i++) {
            for (int j = 1; j <= this.cols; j++) {
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int used = board.getPlayerNow();
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
                                                buttons[x][y].setBorderPainted(false);
                                            }
                                            else if(board.getMineState(x,y)==0){
                                                Image Open = new ImageIcon("src\\view\\pictures\\blankOpen.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }else if(board.getMineState(x,y)==1){
                                                Image Open = new ImageIcon("src\\view\\pictures\\1.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }else if(board.getMineState(x,y)==2){
                                                Image Open = new ImageIcon("src\\view\\pictures\\2.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }else if(board.getMineState(x,y)==3){
                                                Image Open = new ImageIcon("src\\view\\pictures\\3.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }else if(board.getMineState(x,y)==4){
                                                Image Open = new ImageIcon("src\\view\\pictures\\4.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }else if(board.getMineState(x,y)==5){
                                                Image Open = new ImageIcon("src\\view\\pictures\\5.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }else if(board.getMineState(x,y)==6){
                                                Image Open = new ImageIcon("src\\view\\pictures\\6.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }else if(board.getMineState(x,y)==7){
                                                Image Open = new ImageIcon("src\\view\\pictures\\7.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }else if(board.getMineState(x,y)==8){
                                                Image Open = new ImageIcon("src\\view\\pictures\\8.jpg").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }
                                        }
                                    }
                                }
                            }
                            if (playerNum+AINum==1){
                                String MapData = "当前玩家:"+suMembers[board.getPlayerNow()].getName(board.getPlayerNow())+
                                        " 剩余雷数:"+board.getRemain();
                                mapData.setText(MapData);
                            }else {
                                String MapData = "当前玩家:"+suMembers[board.getPlayerNow()].getName(board.getPlayerNow())+
                                        " 剩余雷数:"+board.getRemain()+
                                        " 剩余行动数:"+ (moveNum-board.getMove());
                                mapData.setText(MapData);
                            }
                            String memberData = suMembers[used].getName(used)+" 得分:"+board.getPlayers()[used].getScore()+"失误:"+board.getPlayers()[used].getMiss();
                            suMembers[used].scoreBoard.setText(memberData);
                            if(board.isend){
                                int max = board.getPlayers()[1].getScore();
                                int min = 361;
                                boolean[] scoreJdg = new boolean[5];
                                boolean[] missJdg = new boolean[5];
                                ArrayList<String> nameList = new ArrayList<>();
                                for (int m = 0; m < 5; m++) {
                                    scoreJdg[m]=false;
                                    missJdg[m]=false;
                                }
                                for(int i=1;i<=playerNum+AINum-1;i++){
                                    if(board.getPlayers()[i+1].getScore()>=board.getPlayers()[i].getScore()){
                                        max=board.getPlayers()[i+1].getScore();
                                    }
                                }
                                for (int k = 1; k <= playerNum+AINum; k++) {
                                    if (max==board.getPlayers()[k].getScore()){
                                        scoreJdg[k]=true;
                                    }
                                }
                                for (int j = 1; j <= playerNum+AINum ; j++) {
                                    if (scoreJdg[j]){
                                        if (board.getPlayers()[j].getMiss()<=min){
                                            min=board.getPlayers()[j].getMiss();
                                        }
                                    }
                                }
                                for (int p = 1; p <= playerNum+AINum; p++) {
                                    if (scoreJdg[p]&&min==board.getPlayers()[p].getMiss()){
                                        missJdg[p]=true;
                                    }
                                }
                                for (int n = 1; n <= playerNum+AINum; n++) {
                                    if (scoreJdg[n]&&missJdg[n]){
                                        nameList.add(suMembers[n].getName(n));
                                    }
                                }
                                String winMessage = "";
                                if (nameList.size()==1){
                                    winMessage=String.format("%s 获胜",nameList.get(0));
                                }else {
                                    int numSUM = nameList.size();
                                    if (numSUM==2){
                                        winMessage=String.format("%s,%s 平局",
                                                nameList.get(0),nameList.get(1));
                                    }else if (numSUM==3){
                                        winMessage=String.format("%s,%s,%s 平局",
                                                nameList.get(0),nameList.get(1),nameList.get(2));
                                    }else if (numSUM==4){
                                        winMessage=String.format("%s,%s,%s,%s 平局",
                                                nameList.get(0),nameList.get(1),nameList.get(2),nameList.get(3));
                                    }
                                }

                                JOptionPane.showMessageDialog(gameBoard, winMessage, "游戏结束", JOptionPane.INFORMATION_MESSAGE, null);
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
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 0) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\blankOpen.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 1) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\1.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 2) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\2.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 3) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\3.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 4) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\4.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 5) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\5.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 6) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\6.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 7) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\7.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            } else if (board.getMineState(x, y) == 8) {
                                                Image Open = new ImageIcon("src\\view\\pictures\\8.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                                ImageIcon open = new ImageIcon(Open);
                                                buttons[x][y].setIcon(open);
                                                buttons[x][y].setBorderPainted(false);
                                            }
                                        }
                                    }
                                }
                            }
                            if (playerNum+AINum==1){
                                String MapData = "当前玩家:"+suMembers[board.getPlayerNow()].getName(board.getPlayerNow())+
                                        " 剩余雷数:"+board.getRemain();
                                mapData.setText(MapData);
                            }else {
                                String MapData = "当前玩家:"+suMembers[board.getPlayerNow()].getName(board.getPlayerNow())+
                                        " 剩余雷数:"+board.getRemain()+
                                        " 剩余行动数:"+ (moveNum-board.getMove());
                                mapData.setText(MapData);
                            }
                            String memberData = suMembers[used].getName(used)+" 得分:"+board.getPlayers()[used].getScore()+"失误:"+board.getPlayers()[used].getMiss();
                            suMembers[used].scoreBoard.setText(memberData);
                        }

                        int now = board.getPlayerNow();
                        if (used!=now){
                            if (used==1){
                                Image Picture0 = new ImageIcon("src\\view\\individuation\\member01Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                ImageIcon picture0 = new ImageIcon(Picture0);
                                suMembers[used].setMemberImage(picture0);
                                Image Picture1 = new ImageIcon("src\\view\\individuation\\member02.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                ImageIcon picture1 = new ImageIcon(Picture1);
                                suMembers[now].setMemberImage(picture1);
                            }else if (used==2){
                                if (now==1){
                                    Image Picture0 = new ImageIcon("src\\view\\individuation\\member02Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                    ImageIcon picture0 = new ImageIcon(Picture0);
                                    suMembers[used].setMemberImage(picture0);
                                    Image Picture1 = new ImageIcon("src\\view\\individuation\\member01.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                    ImageIcon picture1 = new ImageIcon(Picture1);
                                    suMembers[now].setMemberImage(picture1);
                                }else {
                                    Image Picture0 = new ImageIcon("src\\view\\individuation\\member02Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                    ImageIcon picture0 = new ImageIcon(Picture0);
                                    suMembers[used].setMemberImage(picture0);
                                    Image Picture1 = new ImageIcon("src\\view\\individuation\\member03.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                    ImageIcon picture1 = new ImageIcon(Picture1);
                                    suMembers[now].setMemberImage(picture1);
                                }
                            }else if (used==3){
                                if (now==1){
                                    Image Picture0 = new ImageIcon("src\\view\\individuation\\member03Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                    ImageIcon picture0 = new ImageIcon(Picture0);
                                    suMembers[used].setMemberImage(picture0);
                                    Image Picture1 = new ImageIcon("src\\view\\individuation\\member01.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                    ImageIcon picture1 = new ImageIcon(Picture1);
                                    suMembers[now].setMemberImage(picture1);
                                }else {
                                    Image Picture0 = new ImageIcon("src\\view\\individuation\\member03Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                    ImageIcon picture0 = new ImageIcon(Picture0);
                                    suMembers[used].setMemberImage(picture0);
                                    Image Picture1 = new ImageIcon("src\\view\\individuation\\member04.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                    ImageIcon picture1 = new ImageIcon(Picture1);
                                    suMembers[now].setMemberImage(picture1);
                                }
                            }else if (used==4){
                                Image Picture0 = new ImageIcon("src\\view\\individuation\\member04Dark.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                ImageIcon picture0 = new ImageIcon(Picture0);
                                suMembers[used].setMemberImage(picture0);
                                Image Picture1 = new ImageIcon("src\\view\\individuation\\member01.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
                                ImageIcon picture1 = new ImageIcon(Picture1);
                                suMembers[now].setMemberImage(picture1);
                            }
                        }
                    }
                });
            }
        }
        cheat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cheatNum.i++;
                if (cheatNum.i%2==1){
                    if(board.hadinit){
                        for(int x=1;x<=rows;x++){
                            for(int y=1;y<=cols;y++){
                                Image cheatmine = new ImageIcon("src\\view\\pictures\\mineCheat.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                ImageIcon cheatmineicon = new ImageIcon(cheatmine);
                                if(board.getMineState(x, y)==9 && board.getOpenState(x,y)==1)buttons[x][y].setIcon(cheatmineicon);
                            }
                        }
                    }
                    else{
                        board.boardInit(1,1);
                        board.hadinit=true;
                        for(int x=1;x<=rows;x++){
                            for(int y=1;y<=cols;y++){
                                Image cheatmine = new ImageIcon("src\\view\\pictures\\mineCheat.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                                ImageIcon cheatmineicon = new ImageIcon(cheatmine);
                                if(board.getMineState(x, y)==9 && board.getOpenState(x,y)==1)buttons[x][y].setIcon(cheatmineicon);
                            }
                        }
                    }
                }else {
                    for(int x=1;x<=rows;x++){
                        for(int y=1;y<=cols;y++){
                            Image Blank = new ImageIcon("src\\view\\pictures\\blankClosed.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                            ImageIcon blank = new ImageIcon(Blank);
                            if(board.getMineState(x, y)==9 && board.getOpenState(x,y)==1)buttons[x][y].setIcon(blank);
                        }
                    }
                }

            }
        });
    }


}