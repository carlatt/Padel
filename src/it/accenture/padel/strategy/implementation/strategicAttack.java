package it.accenture.padel.strategy.implementation;

import it.accenture.padel.strategy.abstraction.Score;
import it.accenture.padel.strategy.abstraction.abstractAttackStrategy;

import java.util.Random;

public class strategicAttack implements abstractAttackStrategy {
    private Random prob;

    public strategicAttack() {
        this.prob = new Random();
    }

    @Override
    public Score attack() {
        float probability = prob.nextFloat();
        if (probability <= 0.33333){
            return Score.GET_POINT;
        }
        return Score.NO_EFFECT;
    }
}
