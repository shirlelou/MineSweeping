package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Board {
    public int row;
    public int col;
    int playerNum;
    public int[][] gridInfo;
    int aiNum;
    int mineNum;
    int playerNow;
    int moveNum;
    int move;
    public boolean hadinit;
    int remain;
    public boolean isend;
    
    Player[] players;

    public Board(int row,int col,int playerNum,int aiNum,int mineNum,int moveNum){
        this.row=row;
        this.col=col;
        this.playerNum=playerNum;
        this.aiNum=aiNum;
        this.moveNum=moveNum;
        this.mineNum=mineNum;
        hadinit=false;
        gridInfo=new int[row+3][col+3];
        players = new Player[aiNum+playerNum+1];
        playerNow=1;
        move=0;
        remain=mineNum;
        isend=false;

        for(int i=1;i<=aiNum+playerNum;i++){
            if(i<=playerNum)players[i]=new Player(i, true);
            if(i>playerNum)players[i]=new Player(i, false);
        }

        
    }

    public Board(){
      /*  FileInputStream document = null;
        //继续游戏 读取存档
        try {
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(document != null){
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       */
    }


    public int getMineState(int x,int y){
        return gridInfo[x][y]/10;
    }
    public int getOpenState(int x,int y){
        return gridInfo[x][y]%10;

    }
    public void setOpenState(int x,int y,int i){
        gridInfo[x][y]=gridInfo[x][y]/10*10+i;
        //1:关闭；2:标记；3:打开
    }
    public int getRemain() {
        return remain;
    }
    public int getMove() {
        return move;
    }
    public int getPlayerNow() {
        return playerNow;
    }
    public Player[] getPlayers() {
        return players;
    }

    public void setMove(int move) {
        this.move = move;
    }
    public void setPlayerNow(int playerNow) {
        this.playerNow = playerNow;
    }
    public void setRemain(int remain) {
        this.remain = remain;
    }
    public int getPlayerNum() {
        return playerNum;
    }
    public int getAiNum() {
        return aiNum;
    }
    
    private boolean check1(int x,int y){
        if(gridInfo[x][y-1]==91&&gridInfo[x][y-2]==91
            &&gridInfo[x-2][y]==91&&gridInfo[x-2][y-1]==91&&gridInfo[x-2][y-2]==91
            &&gridInfo[x-1][y]==91&&gridInfo[x-1][y-1]==91&&gridInfo[x-1][y-2]==91)return true;
            return false;
            //9雷返回真（左上）
    }
    private boolean check2(int x,int y){
        if(gridInfo[x][y+1]==91&&gridInfo[x][y-1]==91
            &&gridInfo[x-2][y]==91&&gridInfo[x-2][y+1]==91&&gridInfo[x-2][y-1]==91
            &&gridInfo[x-1][y]==91&&gridInfo[x-1][y+1]==91&&gridInfo[x-1][y-1]==91)return true;
            return false;
            //9雷返回真（上）
    }
    private boolean check3(int x,int y){
        if(gridInfo[x][y+1]==91&&gridInfo[x][y+2]==91
            &&gridInfo[x-2][y]==91&&gridInfo[x-2][y+1]==91&&gridInfo[x-2][y+2]==91
            &&gridInfo[x-1][y]==91&&gridInfo[x-1][y+1]==91&&gridInfo[x-1][y+2]==91)return true;
            return false;
            //9雷返回真（右上）
    }
    private boolean check4(int x,int y){
        if(gridInfo[x][y-1]==91&&gridInfo[x][y-2]==91
            &&gridInfo[x+1][y]==91&&gridInfo[x+1][y-1]==91&&gridInfo[x+1][y-2]==91
            &&gridInfo[x-1][y]==91&&gridInfo[x-1][y-1]==91&&gridInfo[x-1][y-2]==91)return true;
            return false;
            //9雷返回真（左）
    }
    private boolean check5(int x,int y){
        if(gridInfo[x][y+1]==91&&gridInfo[x][y-1]==91
            &&gridInfo[x+1][y]==91&&gridInfo[x+1][y+1]==91&&gridInfo[x+1][y-1]==91
            &&gridInfo[x-1][y]==91&&gridInfo[x-1][y+1]==91&&gridInfo[x-1][y-1]==91)return true;
            return false;
            //9雷返回真（中）
    }
    private boolean check6(int x,int y){
        if(gridInfo[x][y+1]==91&&gridInfo[x][y+2]==91
            &&gridInfo[x+1][y]==91&&gridInfo[x+1][y+1]==91&&gridInfo[x+1][y+2]==91
            &&gridInfo[x-1][y]==91&&gridInfo[x-1][y+1]==91&&gridInfo[x-1][y+2]==91)return true;
            return false;
            //9雷返回真（右）
    }
    private boolean check7(int x,int y){
        if(gridInfo[x][y-1]==91&&gridInfo[x][y-2]==91
            &&gridInfo[x+1][y]==91&&gridInfo[x+1][y-1]==91&&gridInfo[x+1][y-2]==91
            &&gridInfo[x+2][y]==91&&gridInfo[x+2][y-1]==91&&gridInfo[x+2][y-2]==91)return true;
            return false;
            //9雷返回真（左下）
    }
    private boolean check8(int x,int y){
        if(gridInfo[x][y+1]==91&&gridInfo[x][y-1]==91
            &&gridInfo[x+1][y]==91&&gridInfo[x+1][y+1]==91&&gridInfo[x+1][y-1]==91
            &&gridInfo[x+2][y]==91&&gridInfo[x+2][y+1]==91&&gridInfo[x+2][y-1]==91)return true;
            return false;
            //9雷返回真（下）
    }
    private boolean check9(int x,int y){
        if(gridInfo[x][y+1]==91&&gridInfo[x][y+2]==91
            &&gridInfo[x+1][y]==91&&gridInfo[x+1][y+1]==91&&gridInfo[x+1][y+2]==91
            &&gridInfo[x+2][y]==91&&gridInfo[x+2][y+1]==91&&gridInfo[x+2][y+2]==91)return true;
            return false;
            //9雷返回真（右下）
    }


    public void boardInit(int x0,int y0){


        Random r=new Random();
        int mines=0;
        while(mines<mineNum){
            int x=r.nextInt(row)+1;
            int y=r.nextInt(col)+1;
            
            if(x==x0&&y==y0)continue;
            if(gridInfo[x][y]==91)continue;
            
            if(x==1&&y==1){
                if(check9(x,y))continue;
                else{
                    gridInfo[x][y]=91;
                    mines++;
                    continue;
                }
            }
            if(x==1){
                if(check7(x, y)||check8(x, y)||check9(x, y))continue;
                else{
                    gridInfo[x][y]=91;
                    mines++;
                    continue;
                }
            }
            if(y==1){
                if(check3(x, y)||check6(x, y)||check9(x, y))continue;
                else{
                    gridInfo[x][y]=91;
                    mines++;
                    continue;
                }
            }
            if(!check5(x, y)&&x!=row&&y!=col){
                gridInfo[x][y]=91;
                mines++;
                continue;
            }
            if(check1(x, y)||check2(x, y)||check3(x, y)
            ||check4(x, y)||check5(x, y)||check6(x, y)
            ||check7(x, y)||check8(x, y)||check9(x, y))continue;

            gridInfo[x][y]=91;
            mines++;
        }
        for(int x=1;x<=row;x++){
            for(int y=1;y<=col;y++){
                if(getMineState(x,y)!=9){
                    int count=0;
                    if(getMineState(x-1,y-1)==9)count++;
                    if(getMineState(x-1,y)==9)count++;
                    if(getMineState(x-1,y+1)==9)count++;
                    if(getMineState(x,y-1)==9)count++;
                    if(getMineState(x,y+1)==9)count++;
                    if(getMineState(x+1,y-1)==9)count++;
                    if(getMineState(x+1,y)==9)count++;
                    if(getMineState(x+1,y+1)==9)count++;
                    gridInfo[x][y]+=count*10+1;
                }
            }
        }
    }

    private void open(int x,int y,boolean[][] ret){
        
        if(getMineState(x, y)==0&&getOpenState(x, y)==1){
            ret[x][y]=true;
            gridInfo[x][y]=3;
            if(getMineState(x-1,y-1)!=9&&getOpenState(x-1, y-1)==1)open(x-1,y-1,ret);
            if(getMineState(x-1,y)!=9&&getOpenState(x-1, y)==1)open(x-1,y,ret);
            if(getMineState(x-1,y+1)!=9&&getOpenState(x-1, y+1)==1)open(x-1,y+1,ret);
            if(getMineState(x,y-1)!=9&&getOpenState(x, y-1)==1)open(x,y-1,ret);
            if(getMineState(x,y+1)!=9&&getOpenState(x, y+1)==1)open(x,y+1,ret);
            if(getMineState(x+1,y-1)!=9&&getOpenState(x+1, y-1)==1)open(x+1,y-1,ret);
            if(getMineState(x+1,y)!=9&&getOpenState(x+1, y)==1)open(x+1,y,ret);
            if(getMineState(x+1,y+1)!=9&&getOpenState(x+1, y+1)==1)open(x+1,y+1,ret);
            ret[x][y]=true;
            gridInfo[x][y]=getMineState(x, y)*10+3;
        }
        else if(getMineState(x, y)!=9&&getOpenState(x, y)==1){
            ret[x][y]=true;
            gridInfo[x][y]=getMineState(x, y)*10+3;
        }
        
    }

    public void voidOpen(int x,int y,boolean[][] ret){
        open(x, y, ret);
        players[playerNow].voidOpen();
    }

    public void voidMark(int x,int y,boolean[][] ret){
        open(x, y, ret);
        players[playerNow].voidMark();
    }
    public void numOpen(int x,int y,boolean[][] ret){
        ret[x][y]=true;
        setOpenState(x, y, 3);
        players[playerNow].numOpen();
    }
    public void numMark(int x,int y,boolean[][] ret){
        ret[x][y]=true;
        setOpenState(x, y, 3);
        players[playerNow].numMark();
    }
    public void mineOpen(int x,int y,boolean[][] ret){
        ret[x][y]=true;
        setOpenState(x, y, 3);
        players[playerNow].mineOpen();
        remain--;
    }
    public void mineMark(int x,int y,boolean[][] ret){
        ret[x][y]=true;
        setOpenState(x, y, 2);
        players[playerNow].mineMark();
        remain--;
    }

    private void changePlayer(){
        if(playerNow<playerNum)playerNow++;
        else playerNow=1;
        move=0;
    }


    private boolean checkScore(){
        int maxScore=0;
        int over=0;
        for(int i=1;i<=playerNum;i++){
            if(maxScore<players[i].getScore())maxScore=players[i].getScore();
        }
        for(int i=1;i<=playerNum;i++){
            if(maxScore-players[i].getScore()>remain)over++;
        }
        if(over==playerNum-1)return true;
        return false;
        //如果有玩家胜利就返回true
    }

    private boolean isEnd(){
/*
        获胜条件：每进行一回合均需要比较双方的分数。
        a. 如果双方的分数差距大于游戏区中未揭晓的雷数，则直接判定优势方获胜。
        b. 如果在游戏中所有雷都被揭晓时双方分数依然相同，则失误数少的一方（失误包含误触
        雷以及标记错误）获胜。
        c. 如果失误数依然相同，则双方平局。
*/

        if(playerNum==1){
            if(remain==0)return true;
            else return false;
        }


        if(remain==0)return true;
        if(checkScore())return true;
        return false;
    }

    public void operate(int x,int y,boolean left,boolean[][] ret){

        if(!hadinit){
            boardInit(x, y);
            hadinit=true;
        }

        if(getMineState(x, y)==0&&left)voidOpen(x, y, ret);
        if(getMineState(x, y)==0&&!left)voidMark(x, y, ret);
        if(getMineState(x, y)==9&&left)mineOpen(x, y, ret);
        if(getMineState(x, y)==9&&!left)mineMark(x, y, ret);
        if(getMineState(x, y)>=1&&getMineState(x, y)<=8&&left)numOpen(x, y, ret);
        if(getMineState(x, y)>=1&&getMineState(x, y)<=8&&!left)numMark(x, y, ret);
        move++;
        if(move==moveNum)changePlayer();
        
        //检测是否结束游戏

    }

    public void inFile(){
        FileWriter out = null;
        try {


            File fi;
            String saveFileName = "src/xyz/saving/output.txt";
            JFileChooser fileChooser = new JFileChooser("out\\.");

            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "游戏存档文件(*.txt)", "txt");
            fileChooser.setFileFilter(filter);
            fileChooser.setSelectedFile(new File(saveFileName)); 

            
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
       
             fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setDialogTitle("保存游戏进度文件");
            int value = fileChooser.showSaveDialog(null);
            if (value == fileChooser.APPROVE_OPTION) {
            
            File filex[] = fileChooser.getSelectedFiles();
            for (int i = 0; i < filex.length; i++) {
                System.out.println(filex[i].getAbsolutePath());
                fi = fileChooser.getSelectedFile();
                saveFileName = fi.getAbsolutePath() + ".txt";
                System.out.println("save: " + saveFileName);
            }
            }

            if(saveFileName !=null){
                File file=new File(saveFileName);
                out = new FileWriter(file);
                out.write(playerNum+" "+aiNum+" "+moveNum+"\n");
                out.write(row+" "+col+" "+mineNum+"\n");
                out.write(playerNow+" "+move+" "+remain+"\n");
                for(int i=1;i<=playerNum+aiNum;i++){
                out.write(players[i].getScore()+" ");
                out.write(players[i].getMiss()+"");
                out.write("\n");
            }
            for(int i=1;i<=row;i++){
                for(int j=1;j<=col;j++){
                    out.write(gridInfo[i][j]+" ");
                }
                out.write("\n");
            }
            }
            


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(out !=null)out.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

 /* public boolean checkfile(){
        JFileChooser chooser = new JFileChooser("out\\.");
                chooser.showOpenDialog(gameboard);
                File file = chooser.getSelectedFile();
                if (file == null) {
                    JOptionPane.showMessageDialog(start, "未得到存档文件", "提示", JOptionPane.WARNING_MESSAGE, null);
                }else{
                    FileReader reader = null;
                    try {
                        reader = new FileReader(file);
                        BufferedReader br = new BufferedReader(reader);
                        
                        String nextline;
                        
                        try {
                            nextline = br.readLine();
                            int[] a = new int[40];
                            String[] b = new String[40];
                            b = nextline.split(" ");
                            for(int i=0;i<b.length;i++){
                                a[i] = Integer.parseInt(b[i]);
                            }
                                
                            int playerNum = a[0];
                            int aiNum = a[1];
                            int moveNum = a[2];
                            boardcom[n.i].setSuMembers(playerNum, aiNum, moveNum);
                                    
                                
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            nextline = br.readLine();
                            int[] a = new int[40];
                            String[] b = new String[40];
                            b = nextline.split(" ");
                            for(int i=0;i<b.length;i++){
                                a[i] = Integer.parseInt(b[i]);
                            }
                                
                            int row = a[0];
                            int col = a[1];
                            int mineNum = a[2];
                            boardcom[n.i].setBoard(row , col, mineNum);
                                    
                                
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }

                        try {
                            nextline = br.readLine();
                            int[] a = new int[40];
                            String[] b = new String[40];
                            b = nextline.split(" ");
                            for(int i=0;i<b.length;i++){
                                a[i] = Integer.parseInt(b[i]);
                            }
                                
                            int playerNow = a[0];
                            int move = a[1];
                            int remain = a[2];
                            boardcom[n.i].board.setMove(move);
                            boardcom[n.i].board.setPlayerNow(playerNow);
                            boardcom[n.i].board.setRemain(remain);
                                    
                                
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }


                        try {
                            for(int i=1;i<=boardcom[n.i].board.getPlayerNum()+boardcom[n.i].board.getAiNum();i++){
                                nextline = br.readLine();
                                int[] a = new int[40];
                                String[] b = new String[40];
                                b = nextline.split(" ");
                                for(int j=0;j<b.length;j++){
                                    a[j] = Integer.parseInt(b[j]);
                                }
                                int score = a[0];
                                int miss = a[1];   
                            
                                boardcom[n.i].board.getPlayers()[i].setScore(score);
                                boardcom[n.i].board.getPlayers()[i].setMiss(miss);
                            } 
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }

                        
                        try {
                            for(int x=1;x<=boardcom[n.i].board.row;x++){
                                nextline = br.readLine();
                                int[] a = new int[40];
                                String[] b = new String[40];
                                b = nextline.split(" ");
                                for(int i=0;i<b.length;i++){
                                    if(b[i]==null)break;
                                    a[i] = Integer.parseInt(b[i]);
                                }
                                for(int y=1;y<=boardcom[n.i].board.col;y++){
                                    boardcom[n.i].board.gridInfo[x][y]=a[y-1];
                                }
                                
                            } 
                            
                            
                        } catch (NumberFormatException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }finally{
                        try {
                            reader.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    boardcom[n.i].refreshData();
                    setContentPane(boardcom[n.i]);
                    n.i++;
                } 
            }
    }
*/

}
