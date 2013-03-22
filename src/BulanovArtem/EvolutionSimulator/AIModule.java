package BulanovArtem.EvolutionSimulator;

import java.util.Set;

/**
 * SimpleAIModule
 * User: aielemental
 * Date: 19.09.12
 * Time: 15:11
 */
//todo add descriptionpackage BulanovArtem.EvolutionSimulator;
public interface AIModule extends Runnable, Identified{
    Action decideAction(Set<Being> beings, BehaviourType behaviourType);
    BehaviourType decideBehaviourType(Stats constStats);
    void perform(Action a);
}
