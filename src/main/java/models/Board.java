package models;
import java.util.*;
public class Board {
    int finalPosition;
    int startPosition;

    List<Snake>  snakeList;
    List<Ladder> ladderList;

    Deque<Player> playerList;

    public Board(List<Snake> snakeList,List<Ladder> ladderList, Deque<Player> players,int boardSize)
    {
        this.snakeList = snakeList;
        this.ladderList = ladderList;
        this.playerList = players;
        this.finalPosition = boardSize;
        this.startPosition = 0;
    }

    public Deque<Player> getPlayerList(){
        return playerList;
    }

    public List<Ladder> getLadderList(){
        return ladderList;
    }

    public List<Snake> getSnakeList(){
        return snakeList;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public Character getCharacter(int position) {
        Optional<Snake> snakeAtPosition = snakeList.stream().filter(snake -> snake.getStart() == position).findFirst();
        if (snakeAtPosition.isPresent()) {
            System.out.println("Using Snake of : "+ snakeAtPosition.get().startPoint);
            return snakeAtPosition.get();
        }
        Optional<Ladder> ladderAtPostion = ladderList.stream().filter(ladder -> ladder.getStart() == position).findFirst();
        if (ladderAtPostion.isPresent()) {
            System.out.println("Using ladder of : "+ ladderAtPostion.get().startPoint);
            return ladderAtPostion.get();
        }
        return null;
    }

    public void displayBoard(){
        System.out.println("Snake Count is : " + snakeList.size());
        snakeList.stream().forEach(snake -> System.out.println("Snake is from : " + snake.startPoint + " " + snake.endPoint));
        System.out.println("Ladder Count is : " + ladderList.size());
        ladderList.stream().forEach(ladder -> System.out.println("ladder is from : " + ladder.startPoint + " " + ladder.endPoint));
    }

}
