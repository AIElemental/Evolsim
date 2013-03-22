package BulanovArtem.EvolutionSimulator;

import java.lang.reflect.InvocationTargetException;

/**
 * Action
 * User: aielemental
 * Date: 19.09.12
 * Time: 15:14
 */
//todo add description
public interface Action {
    void go() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
