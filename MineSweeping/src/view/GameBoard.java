package view;
import java.awt.*;
import javax.swing.*;



public class GameBoard extends JPanel{
    private int rows;
    private int cols;
    private JButton[][] buttons;
    private final int BlockWidth = 25;
    private final int BlockHeight = 25;
    Image retsicon = new ImageIcon("src\\view\\pictures\\returnicon.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    ImageIcon returnicon = new ImageIcon(retsicon);

    public GameBoard(int row,int col){
        setSize(818,805);
        setLayout(null);

        rows=row;
        cols=col;
        buttons=new JButton[rows][cols];

        initButton();
    }

    public void initButton() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                buttons[i][j] = new JButton(returnicon);
                buttons[i][j].setBounds(i * 25 + 230, j * 25 + 48, BlockWidth, BlockHeight);
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