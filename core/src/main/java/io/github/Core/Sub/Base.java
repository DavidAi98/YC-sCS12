package io.github.Core.Sub;



public class Base {
    private double health;
    private double attack;
    private double defence;



    public Base(double health, double attack, double defence){
        this.health = health;
        this.attack = attack;
        this.defence = defence;

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

    public double getHealth(){
        return health;
    }

    public double getAttack(){
        return attack;
    }

    public double getDefence(){
        return defence;
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





    public void damage(double cA,double cM){
        health-=cA*cM/defence;
    }


}
