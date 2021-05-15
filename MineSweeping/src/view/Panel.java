package view;
import java.awt.*;
import javax.swing.*;


public class Panel extends JPanel{
    private int rows;
    private int cols;
    private int bombCount;
    private final int BlockWidth = 20;
    private final int BlockHeight = 20;
    private JLabel[][] labels;

    public Panel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.bombCount = rows * cols / 10;
        this.labels = new JLabel[rows][cols];
        this.setLayout(null);
        this.setFirLabel();
    }

    private void setFirLabel(){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                JLabel jLabel = new JLabel("",JLabel.CENTER);
                jLabel.setBounds(j*BlockWidth+180,j*BlockHeight+50,BlockWidth,BlockHeight);
                jLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                jLabel.setOpaque(true);
                jLabel.setBackground(Color.lightGray);
                this.add(jLabel);
                labels[i][j]=jLabel;
            }
        }
    }

    public int[] backSize () {
        int[] size = {this.cols*BlockWidth + 100, this.rows*BlockHeight + 20};
        return size;
    }


}
