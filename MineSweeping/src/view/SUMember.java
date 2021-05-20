package view;
import java.awt.*;
import javax.swing.*;

public class SUMember extends JPanel{
    private JButton memberImage = new JButton(new ImageIcon());
    private JLabel scoreBoard = new JLabel();
    private int orderNum;
    private int score = 0;
    private int miss = 0;
    private String memberData;

    public SUMember (int orderNum){
        this.orderNum = orderNum;
    }

    public JButton accessMemberImage(int k){
        orderNum=k;
        initMemberImage();
        memberImage.setBounds(10,orderNum*200,160,160);
        return memberImage;
    }

    public JLabel getScore(){
        scoreBoard.setBounds(10,orderNum*200+160,160,30);
        Font font = new Font("黑体",Font.BOLD,12);
        scoreBoard.setFont(font);
        return scoreBoard;
    }

    public void SUMemData() {
        memberData = "玩家"+(orderNum)+"得分数:"+score+"失误数:"+miss;
        scoreBoard.setText(memberData);
    }


    public JButton initMemberImage(){
        if (orderNum==1){
            memberImage.setIcon(new ImageIcon("view/individuation/member01.png"));
        }else if (orderNum==2){
            memberImage.setIcon(new ImageIcon("view/individuation/member02.png"));
        }else if (orderNum==3){
            memberImage.setIcon(new ImageIcon("view/individuation/member03.png"));
        }else if (orderNum==4){
            memberImage.setIcon(new ImageIcon("view/individuation/member04.png"));
        }
        return memberImage;
    }
}

