package it.accenture.padel.model;

import it.accenture.padel.strategy.abstraction.Score;

import java.util.Random;

public class Match {
    private Team teamA;
    private Team teamB;

    private final int scoreForWinning = 21;

    private final int scoreAggressive = 15;

    private boolean aggressiveMode;


    public Match(Team a, Team b) {
        this.teamA = a;
        this.teamB = b;
        this.aggressiveMode = false;
    }

    public void play(){
        Random rand = new Random();
        Team attacker;
        Team defender;
        if (rand.nextFloat() < 0.5){
            attacker = teamA;
            defender = teamB;
        } else {
            attacker = teamB;
            defender = teamA;
        }
        while (!checkGameOver(attacker, defender)){
            System.out.println("Attacker: "+attacker.getName()+", Defender: "+ defender.getName());
            if (attacker.attack().equals(Score.GET_POINT) && defender.defend().equals(Score.GIVE_POINT) ) {
                System.out.println(attacker.getName()+" gets the point");
                attacker.addPoint();
            } else if (attacker.attack().equals(Score.GIVE_POINT) && defender.defend().equals(Score.GET_POINT) ) {
                System.out.println(defender.getName()+" gets the point");
                defender.addPoint();
            } else {
                System.out.println("still playing");
            }


            System.out.println(teamA.getName()+": "+teamA.getScore()+", "+teamB.getName()+": "+teamB.getScore());


            var sw = attacker;
            attacker = defender;
            defender = sw;

            if (!aggressiveMode){
                checkIfStartingAggressiveMode();
                if (aggressiveMode){
                    System.out.println("Aggressive mode started");
                }
            }

            System.out.println();

            //wait1sec();

        }

        System.out.println("The winner is "+declareWinner().getName());
    }

    private boolean checkGameOver(Team attacker, Team defender) {
        return (attacker.getScore()>=scoreForWinning || defender.getScore()>=scoreForWinning);
    }

    private Team declareWinner(){
        if (teamA.getScore()>=scoreForWinning) {
            return teamA;
        }
        return teamB;
    }

    private void checkIfStartingAggressiveMode(){
        if (teamA.getScore()>=scoreAggressive){
            teamA.intensiveMode();
            teamB.strategicMode();
            aggressiveMode = true;
        }

        if (teamB.getScore() >= scoreAggressive){
            teamA.strategicMode();
            teamB.intensiveMode();
            aggressiveMode = true;
        }
    }

    private void wait1sec(){
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}
