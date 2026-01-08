package io.github.Core;

public class Character {
    private double health;
    private double attack;
    private double defence;
    private String state;
    private double x,y;
    private double heading;
    private static int nOfCharacters;

    public Character(double health, double attack, double defence, String state, double x, double y, double heading){
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.state = state;
        this.x = x;
        this.y = y;
        this.heading = heading;
        nOfCharacters++;
    }

    public void setHealth(double health){
        this.health = health;
    }

    public void setAttack(double attack){
        this.attack = attack;
    }

    public void setDefence(double defence){
        this.defence = defence;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setHeading(double heading){
        this.heading = heading;
    }

    public double getHealth(){
        return health;
    }

    public double getAttack(){
        return attack;
    }

    public double getDefence(){
        return defence;
    }

    public String getState(){
        return state;
    }
     public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getHeading(){
        return heading;
    }

    public static double getNOfCharacters(){
        return nOfCharacters;
    }

    public void move(double dx,double dy){
        x += dx;
        y += dy;
    }


    public void moveTo(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void turnTo(double heading){
        this.heading = heading;
    }

    public void deHealth(double de){
        health -= de;
    }

    public void deAttack(double de){
        attack -= de;
    }
    public void deDefence(double de){
        defence -= de;
    }
    public void inHealth(double in){
        health += in;
    }

    public void inAttack(double in){
        attack+=in;
    }

    public void inDefence(double in){
        defence+=in;
    }

}
