package BulanovArtem.EvolutionSimulator;

import java.util.Collection;

/**
 * WorldPhysics
 * User: aielemental
 * Date: 19.03.13
 * Time: 12:04
 */
//todo add description
public class WorldPhysics {
    public static int TIME_QUANTUM_MILLIS = 200;

    public static Being getClosestBeing(Point3 base, Collection<Being> beings, ConditionChecker checker) {
        if (beings.isEmpty()) {
            return null;
        }
        Being closest = null;
        double distance = 1000000.0;
        double tmp;
        for (Being being : beings) {
            if (checker.check(being)) {
                tmp = being.getPosition().minus(base).modulo();
                if (distance > tmp) {
                    distance = tmp;
                    closest = being;
                }
            }
        }
        return closest;
    }
    synchronized public static int nextID() {
        return globalID++;
    }
    private static int globalID = 0;
}
