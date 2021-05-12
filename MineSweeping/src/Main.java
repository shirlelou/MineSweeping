import javax.swing.*;

import view.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);

            /*
            BoardComponent boardComponent = new BoardComponent(10, 10, 900, 800);
            Board board = new Board(10, 10);
            ScoreBoard scoreBoard = new ScoreBoard();
            GameController gameController = new GameController(boardComponent, board, scoreBoard);

            GameFrame gameFrame = new GameFrame();
            gameFrame.add(boardComponent);
            gameFrame.setVisible(true);
            scoreBoard.setVisible(true);*/
        });
    }
}
