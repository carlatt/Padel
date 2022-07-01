package it.accenture.padel.strategy.implementation;

import it.accenture.padel.strategy.abstraction.Score;
import it.accenture.padel.strategy.abstraction.abstractDefenseStrategy;

import java.util.Random;

public class intensiveDefense implements abstractDefenseStrategy {
    private Random prob;

    public intensiveDefense() {
        this.prob = new Random();
    }
    @Override
    public Score defend() {
        float probability = prob.nextFloat();
        if (probability<=0.2){
            return Score.GET_POINT;
        }
        if (probability>0.2 && probability<=0.6){
            return Score.GIVE_POINT;
        }
        return Score.NO_EFFECT;
    }
}
