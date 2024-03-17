package models;

import java.util.Random;

public class Dice {
    int start;
    int end;
    public Dice(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int rollDice(){
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }
}
