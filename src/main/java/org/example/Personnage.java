package org.example;

public class Personnage {
    private boolean mort;
    private int points;

    public Personnage(boolean m, int p){
        this.mort=m;
        this.points=p;
    }

    public boolean est_Mort(){
        return this.mort;
    }

    public void setMort(){ // je suppose qu'on ne peut que inverser vu que c'est un booleans
        this.mort= !mort;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void Tuer()
    {
        this.points = 0;
        this.mort = true;
    }
}
