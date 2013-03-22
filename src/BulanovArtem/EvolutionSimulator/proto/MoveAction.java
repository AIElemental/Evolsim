package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.Action;
import BulanovArtem.EvolutionSimulator.Being;
import BulanovArtem.EvolutionSimulator.Point3;
import sun.reflect.generics.scope.MethodScope;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * MoveAction
 * User: aielemental
 * Date: 21.09.12
 * Time: 13:51
 */
//todo add description
public class MoveAction implements Action {
    Being b;
    Point3 p;
    
    public MoveAction(Being b, Point3 p){
        this.b = b;
        this.p = p;
    }
    public void go(){
        b.moveTo(p);
    }

    @Override
    public String toString() {
        return "Action("+b+" goes to " + p + ")";
    }
}
