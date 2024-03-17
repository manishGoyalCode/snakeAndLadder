package models;

public class Player {
    String name;
    int currentPosition;

    public Player(String name,int initialPostion)
    {
        this.name =name;
        this.currentPosition = initialPostion;
    }

    public String getName(){
        return name;
    }


    public int getCurrentPosition(){
        return this.currentPosition;
    }

    public void setCurrentPosition(int currentPosition){
        this.currentPosition = currentPosition;
    }
}
