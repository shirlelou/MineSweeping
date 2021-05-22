package view;
import java.awt.*;
import javax.swing.*;



public class GameBoard extends JPanel{
    private int rows;
    private int cols;
    private JButton[][] buttons;
    private final int BlockWidth = 25;
    private final int BlockHeight = 25;
    Image Blank = new ImageIcon("src\\view\\pictures\\blankClosed.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
    ImageIcon blank = new ImageIcon(Blank);

    public GameBoard(int row,int col){
        setSize(990,805);
        setLayout(null);

        rows=row;
        cols=col;
        buttons=new JButton[rows+1][cols+1];

        initButton();
    }

    public void initButton() {
        for (int i = 1; i <= this.rows; i++) {
            for (int j = 1; j <= this.cols; j++) {
                buttons[i][j] = new JButton(blank);
                buttons[i][j].setBounds((j-1) * 25 + 220+(380-(25*cols)/2), (i-1) * 25 + 77+(300-(25*rows)/2), BlockWidth, BlockHeight);
                add(buttons[i][j]);
            }
        }
    }

    public JButton[][] getButtons(){
        return buttons;
    }
    public void setButtons(JButton[][] buttons){
        this.buttons=buttons;
    }
}