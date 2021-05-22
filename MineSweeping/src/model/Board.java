package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Board {
    int row;
    int col;
    int playerNum;
    int[][] gridInfo;
    int aiNum;
    int mineNum;
    int playerNow;
    int moveNum;
    int move;
    boolean hadinit;
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


    private void boardInit(int x0,int y0){


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
            if(check1(1, y)||check2(x, y)||check3(x, y)
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
    }
    public void mineMark(int x,int y,boolean[][] ret){
        ret[x][y]=true;
        setOpenState(x, y, 2);
        players[playerNow].mineMark();
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
            if(maxScore-players[i].getScore()>=remain)over++;
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

        if(isEnd()){
            isend=true;  
            File out = new File("out.txt");  
            // 路径为文件且不为空则进行删除  
            if (out.isFile() && out.exists()) {  
                out.delete();    
            }    
        }
        


        FileWriter out = null;
        try {
            out = new FileWriter("out.txt");
            out.write(playerNum+" "+aiNum+" "+moveNum+"\n");
            out.write(row+" "+col+" "+mineNum+"\n");
            out.write(playerNow+" "+move+" "+remain+"\n");
            for(int i=1;i<=row;i++){
                for(int j=1;j<=col;j++){
                    out.write(gridInfo[i][j]+" ");
                }
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
