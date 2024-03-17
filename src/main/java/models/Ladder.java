package models;

public class Ladder extends Character {

    public Ladder(int startPoint,int endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    @Override
    public int getJump(){
        return endPoint - startPoint;
    }

    public int getStart(){
        return startPoint;
    }

    @Override
    public int getEndPoint() {
        return endPoint;
    }
}
