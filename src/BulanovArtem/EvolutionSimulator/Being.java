package BulanovArtem.EvolutionSimulator;

import java.util.Set;

/**
 * CellCreature
 * User: aielemental
 * Date: 19.09.12
 * Time: 15:12
 */
//todo add descriptionpackage BulanovArtem.EvolutionSimulator;
public interface Being extends Obstacle, Identified{
    Stats getConstStats();
    Stats getDynamicStats();
    Set<Being> getSurroundingBeings();
    Being bear();
    Being split();
    boolean isAlive();
    void moveTo(Point3 p);
    AIModule getAI();
    int getClassID();
}
