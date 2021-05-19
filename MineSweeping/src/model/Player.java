package model;

public class Player {
    private boolean ishuman;
    private int orderNum;
    private int miss;
    private int score;
    
    public Player(int orderNum,boolean ishuman){
        this.orderNum=orderNum;
        miss=0;
        score=0;
        this.ishuman=ishuman;
    }

    public void voidOpen(){

    }
    public void voidMark(){
        miss++;
    }
    public void numOpen(){

    }
    public void numMark(){
        miss++;
    }
    public void mineOpen(){
        score--;
    }
    public void mineMark(){
        score++;
    }
}
