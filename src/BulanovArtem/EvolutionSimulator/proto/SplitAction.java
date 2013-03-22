package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.Action;
import BulanovArtem.EvolutionSimulator.Being;

import java.lang.reflect.InvocationTargetException;

/**
 * SplitAction
 * User: aielemental
 * Date: 22.03.13
 * Time: 0:04
 */
//todo add description
public class SplitAction implements Action {
    public SplitAction(Being b) {
        being = b;
    }
    public void go() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Being child = being.split();
        Supervisor.getSupervisor().registerBeing(child);
    }

    private Being being;
}
