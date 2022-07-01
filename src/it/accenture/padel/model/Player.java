package it.accenture.padel.model;

import it.accenture.padel.strategy.abstraction.Score;
import it.accenture.padel.strategy.abstraction.abstractAttackStrategy;
import it.accenture.padel.strategy.abstraction.abstractDefenseStrategy;

public class Player {

    private abstractAttackStrategy attackStrategy;
    private abstractDefenseStrategy defenseStrategy;

    public Player(abstractAttackStrategy attackStrategy, abstractDefenseStrategy defenseStrategy) {
        this.attackStrategy = attackStrategy;
        this.defenseStrategy = defenseStrategy;
    }

    public Score attack(){
        return attackStrategy.attack();
    }

    public Score defend(){
        return defenseStrategy.defend();
    }

    public abstractAttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(abstractAttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public abstractDefenseStrategy getDefenseStrategy() {
        return defenseStrategy;
    }

    public void setDefenseStrategy(abstractDefenseStrategy defenseStrategy) {
        this.defenseStrategy = defenseStrategy;
    }
}
