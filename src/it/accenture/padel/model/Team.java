package it.accenture.padel.model;

import it.accenture.padel.strategy.abstraction.Score;
import it.accenture.padel.strategy.implementation.intensiveAttack;
import it.accenture.padel.strategy.implementation.intensiveDefense;
import it.accenture.padel.strategy.implementation.strategicAttack;
import it.accenture.padel.strategy.implementation.strategicDefense;

import java.util.Random;

public class Team {
    private String name;
    private int score;
    private Player playerRight;
    private Player playerLeft;

    private Random prob;

    public Team(String name) {
        this.name = name;
        this.score = 0;
        this.playerRight = new Player(new intensiveAttack(), new intensiveDefense());
        this.playerLeft = new Player(new strategicAttack(), new strategicDefense());
        this.prob = new Random();
    }

    public Score attack(){
        float probability = prob.nextFloat();
        if (probability<0.5){
            return playerRight.attack();
        }
        return  playerLeft.attack();
    }

    public Score defend(){
        float probability = prob.nextFloat();
        if (probability<0.5){
            return playerRight.defend();
        }
        return  playerLeft.defend();
    }

    public void intensiveMode(){
        playerLeft.setAttackStrategy(new intensiveAttack());
        playerLeft.setDefenseStrategy(new intensiveDefense());
    }

    public void strategicMode(){
        playerRight.setAttackStrategy(new strategicAttack());
        playerRight.setDefenseStrategy(new strategicDefense());
    }

    public void addPoint(){
        score++;
    }

    public void resetScore(){
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
