package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.Action;
import BulanovArtem.EvolutionSimulator.Being;

import java.lang.reflect.InvocationTargetException;

/**
 * BearAction
 * User: aielemental
 * Date: 21.03.13
 * Time: 22:45
 */
//todo add description
public class BearAction implements Action {
    public BearAction(Being b) {
        being = b;
    }
    public void go() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Being child = being.bear();
        Supervisor.getSupervisor().registerBeing(child);
    }
    
    private Being being;
}
