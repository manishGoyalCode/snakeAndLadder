package service;

import models.Board;
import models.Ladder;
import models.Player;
import models.Snake;

import java.util.*;

public class Input {

    public static Board inputBoard(){
        Scanner myObj = new Scanner(System.in);
        List<Snake> snakeList = new ArrayList<>();
        System.out.println("Enter Snake Detail");
        int snakeCount = myObj.nextInt();
        for (int i = 0; i < snakeCount; i++){
            int startPoint = myObj.nextInt();
            int endPoint = myObj.nextInt();
            Snake snake = new Snake(startPoint, endPoint);
            snakeList.add(snake);
        }

        System.out.println("Enter Ladder Detail");
        List<Ladder> ladderList = new ArrayList<>();
        int ladderCount = myObj.nextInt();
        for (int i = 0; i < ladderCount; i++){
            int startPoint = myObj.nextInt();
            int endPoint = myObj.nextInt();
            Ladder ladder = new Ladder(startPoint, endPoint);
            ladderList.add(ladder);
        }
        System.out.println("Enter Player detail");
        Deque<Player> playerList = new LinkedList<>();
        int playerCount = myObj.nextInt();
        myObj.nextLine();
        for (int i = 0; i < playerCount; i++){
            String playerName = myObj.nextLine();

            int startPoint = 0;
            Player player = new Player(playerName,startPoint);
            playerList.addLast(player);
        }
        int boardSize = 100;
        System.out.println("Input Completed");
        Board board = new Board(snakeList, ladderList, playerList, boardSize);
        return board;
    }
}
