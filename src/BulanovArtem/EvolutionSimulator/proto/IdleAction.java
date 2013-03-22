package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.Action;
import BulanovArtem.EvolutionSimulator.Being;
import BulanovArtem.EvolutionSimulator.Point3;
import BulanovArtem.EvolutionSimulator.Random;

import java.lang.reflect.InvocationTargetException;

/**
 * IdleAction
 * User: aielemental
 * Date: 19.03.13
 * Time: 13:01
 */
//todo add description
public class IdleAction implements Action {
    public void go() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        new MoveAction(being, being.getPosition().plus(Random.getRandomIdentityVector2(being.ID()).multiply(3.0))).go();
    }
    @Override
    public String toString() {
        return "Idle Action on " + being.ID();
    }
    public IdleAction(Being b) {
        being = b;
    }
    
    private Being being;
}