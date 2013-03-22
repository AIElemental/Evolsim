package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * SimpleAIModule
 * User: aielemental
 * Date: 14.07.12
 * Time: 14:27
 */
//todo add description
public class SimpleAIModule implements AIModule, Runnable{   
    
    SimpleAIModule(CellCreature b){
        myBeing = b;
        behaviourType = decideBehaviourType(myBeing.getConstStats());
        ID = WorldPhysics.nextID();
    }

    Point3 getVelocityTo(Obstacle o) {
        Point3 velocity = o.getPosition().minus(myBeing.getPosition());
        velocity.normalize();
        return velocity;
    }

    public void run() {        
        while (myBeing.isAlive()) {
            //System.out.println(this);
            myBeing.getDynamicStats().get(StatType.D_HUNGER).addToValue(1);
            perform(decideAction(myBeing.getSurroundingBeings(), behaviourType));
            try {
                Thread.sleep(WorldPhysics.TIME_QUANTUM_MILLIS);
            } catch (InterruptedException e) {
                System.err.print("Oops!");
            }
        }
        Supervisor.getSupervisor().deregisterBeing(myBeing);
    }

    public Action decideAction(Set<Being> beings, BehaviourType behaviourType) {
        Action a;
        double hunger = myBeing.getDynamicStats().get(StatType.D_HUNGER).getValue();
        if (myBeing.childReady()) {
            if (Math.random() > 0.9) {
                a = new BearAction(myBeing);
            } else {
                a = new SplitAction(myBeing);
            }
            System.out.println(a);
        } else {
            /*if (hunger > myBeing.getConstStats().get(StatType.C_MAX_HEALTH).getValue()) {
                myBeing.getDynamicStats().get(StatType.D_HEALTH).addToValue(-10);
            }*/
            Being closest = getClosestBeing(new ConditionChecker() {
                public boolean check(Being b) {
                    return b.isAlive()
                            && b.getClassID() != myBeing.getClassID();
                }
            });
            if (closest == null) {
                a = new IdleAction(myBeing);
            } else if (myBeing.getPosition().isInRadius(closest.getPosition(), 3.0)) {
                a = new EatAction(myBeing, closest);
            } else {
                a = new MoveAction(myBeing, myBeing.getPosition().plus(getVelocityTo(closest)));
            }
        }
        //System.out.println(a);
        return a;
    }

    public BehaviourType decideBehaviourType(Stats s) {
        return BehaviourType.CARNIVORE;
    }

    public void perform(Action a) {
        try {
            //System.out.println(this + " " + a + " go");
            a.go();
        } catch (NoSuchMethodException impossible) {
        } catch (InvocationTargetException impossible) {
        } catch (IllegalAccessException impossible) {
        }
    }

    public int ID() {
        return ID;
    }

    @Override
    public String toString(){
        return "SimpleAI(" + ID + ")";
    }
    
    private Being getClosestBeing(ConditionChecker checker) {
        return WorldPhysics.getClosestBeing(myBeing.getPosition(), myBeing.getSurroundingBeings(), checker);
    }
    
    private CellCreature myBeing;
    private BehaviourType behaviourType;
    private final int ID;

}
