package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BoardComponent extends Panel {
    private JLabel labels;
    private int rows;
    private int cols;
    private int bombCount;
    private SUMember suMember;
    public BoardComponent(int rows, int cols, int bombCount) {
        super(rows, cols, bombCount);
    }

    private JButton aButton = new JButton();
    private JButton[][] buttons = new JButton[rows][cols];
    public void initButton(){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                aButton.setBounds(j*25+180,j*25+48,25,25);
                this.add(aButton);
                buttons[i][j]=aButton;
                aButton.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1){

                        }
                        if (e.getButton() == MouseEvent.BUTTON3){

                        }
                    }
                });
            }
        }
    }


}
