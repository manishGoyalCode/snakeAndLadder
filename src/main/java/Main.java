import models.Board;
import service.BoardPlay;
import service.Input;

public class Main {
    public static void main(String[] args) {
        Board board = Input.inputBoard();
        board.displayBoard();
        BoardPlay.playGame(board);
    }
}