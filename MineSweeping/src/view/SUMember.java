package view;
import java.awt.*;
import javax.swing.*;

public class SUMember extends JPanel{
    private JButton memberImage = new JButton();
    private JLabel scoreBoard = new JLabel();
    private int orderNum;
    private int score = 0;
    private int miss = 0;
    private String memberData;

    public SUMember (int orderNum){
        setLayout(null);
        setSize(160,190);

        this.orderNum = orderNum;
        accessMemberImage();
        getScoreBoard();
        SUMemData();

    }

    public void accessMemberImage(){
        initMemberImage();
        memberImage.setBounds(0,0,160,160);
        add(memberImage);
    }

    public void getScoreBoard(){
        scoreBoard.setBounds(0,160,160,30);
        Font font = new Font("黑体",Font.BOLD,12);
        scoreBoard.setFont(font);
    }

    public void SUMemData() {
        memberData = "玩家"+(orderNum)+"得分数:"+score+"失误数:"+miss;
        scoreBoard.setText(memberData);
        add(scoreBoard);
    }


    public void initMemberImage(){
        if (orderNum==1){
            Image Picture = new ImageIcon("src\\view\\individuation\\member01.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
            ImageIcon picture = new ImageIcon(Picture);
            memberImage.setIcon(picture);
        }else if (orderNum==2){
            Image Picture = new ImageIcon("src\\view\\individuation\\member02.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
            ImageIcon picture = new ImageIcon(Picture);
            memberImage.setIcon(picture);
        }else if (orderNum==3){
            Image Picture = new ImageIcon("src\\view\\individuation\\member03.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
            ImageIcon picture = new ImageIcon(Picture);
            memberImage.setIcon(picture);
        }else if (orderNum==4){
            Image Picture = new ImageIcon("src\\view\\individuation\\member04.jpg").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
            ImageIcon picture = new ImageIcon(Picture);
            memberImage.setIcon(picture);
        }
    }
}

