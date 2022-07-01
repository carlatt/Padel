package it.accenture.padel.strategy.implementation;

import it.accenture.padel.strategy.abstraction.Score;
import it.accenture.padel.strategy.abstraction.abstractDefenseStrategy;

import java.util.Random;

public class strategicDefense implements abstractDefenseStrategy {
    private Random prob;

    public strategicDefense() {
        this.prob = new Random();
    }

    @Override
    public Score defend() {
        float probability = prob.nextFloat();
        if (probability<0.2){
            return Score.GIVE_POINT;
        }
        return Score.NO_EFFECT;
    }
}
