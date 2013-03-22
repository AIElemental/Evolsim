package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.*;

import java.lang.reflect.InvocationTargetException;

/**
 * EatAction
 * User: aielemental
 * Date: 14.03.13
 * Time: 11:49
 */
//todo add description
public class EatAction implements Action {
    public static final double EATING_EFFICIENCY = 2.0;

    public void go() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //System.out.println("Bite!!!");
        Stat eaterAttack = eater.getConstStats().get(StatType.C_ATTACK);
        Stat eaterHunger = eater.getDynamicStats().get(StatType.D_HUNGER);

        Stat victimHealth = victim.getDynamicStats().get(StatType.D_HEALTH);

        victimHealth.addToValue(-eaterAttack.getValue());
        eaterHunger.addToValue(-eaterAttack.getValue() * EATING_EFFICIENCY);
        eater.getDynamicStats().get(StatType.D_EATEN).addToValue(eaterAttack.getValue() * EATING_EFFICIENCY);
    }
    public EatAction(Being eater, Being victim) {
        this.victim = victim;
        this.eater = eater;
    }
    @Override
    public String toString() {
        return "Eat Action (" + eater.ID() + ")->(" + victim.ID() + ")";
    }
    
    private Being eater;
    private Being victim;
}
