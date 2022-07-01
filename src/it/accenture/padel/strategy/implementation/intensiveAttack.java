package it.accenture.padel.strategy.implementation;

import it.accenture.padel.strategy.abstraction.Score;
import it.accenture.padel.strategy.abstraction.abstractAttackStrategy;

import java.util.Random;

public class intensiveAttack implements abstractAttackStrategy {
    private Random prob;

    public intensiveAttack() {
        this.prob = new Random();
    }
    @Override
    public Score attack() {
        float probability = prob.nextFloat();
        if (probability <= 0.33333){
            return Score.GIVE_POINT;
        }
        return Score.GET_POINT;
    }
}
