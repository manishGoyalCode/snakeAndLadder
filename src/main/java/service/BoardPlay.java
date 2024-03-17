package service;

import models.Board;
import models.Character;
import models.Dice;
import models.Player;

import java.util.Deque;
import java.util.List;
import java.util.Random;

public class BoardPlay {

    public static void playGame(Board board){
        Deque<Player> players = board.getPlayerList();
        Dice dice =new Dice(1,6);
        System.out.println("Playing Game");
        while (players.size() >= 2) {
            Player currentPlayer = players.getFirst();
            players.removeFirst();
            int playerCurrentPosition = currentPlayer.getCurrentPosition();
            int diceValue = dice.rollDice();
            movePlayer(currentPlayer, diceValue, board);
            System.out.println(currentPlayer.getName() + " rolled a " + diceValue + " and moved from " + playerCurrentPosition + " to " + currentPlayer.getCurrentPosition());
            if(isPlayerWon(currentPlayer,board.getFinalPosition())){
                System.out.println(currentPlayer.getName() + " wins the game");
            }
            else {
                players.addLast(currentPlayer);
            }
        }
    }

    public static void movePlayer(Player player, int diceValue, Board board) {
        if (!canPlayerMove(player, diceValue, board.getFinalPosition())) {
            return;
        }
        int newPosition = player.getCurrentPosition() + diceValue;
        Character character = board.getCharacter(newPosition);
        while (character != null) {
            newPosition = character.getEndPoint();
            character = board.getCharacter(newPosition);
        }
        player.setCurrentPosition(newPosition);
    }

    public static boolean canPlayerMove(Player player, int stepCount, int boardSize) {
        int playerCurrentPostion = player.getCurrentPosition();
        if (player.getCurrentPosition() + stepCount > boardSize) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPlayerWon(Player player, int boardSize) {
        return player.getCurrentPosition() == boardSize;
    }

}
