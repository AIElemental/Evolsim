package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.*;

import java.util.Set;

/**
 * CellCreature
 * User: aielemental
 * Date: 14.07.12
 * Time: 14:20
 */
//todo add description
public class CellCreature implements Being {
    
    public void go(Point3 p){
        pos.add(p);
        System.out.println("Go + " + pos);
    }

    public CellCreature(Point3 p, Stats constStats, Stats dynamicStats, int inClassID){
        classID = inClassID;
        pos = p;
        this.constStats = constStats;
        this.dynamicStats = dynamicStats;
        childDynamicStats = dynamicStats.clone();

        obstacleType = ObstacleType.BEING;
        ai = new SimpleAIModule(this);
        ID = WorldPhysics.nextID();
    }

    public AIModule getAI() {
        return ai;
    }

    public int getClassID() {
        return classID;
    }

    public int ID() {
        return ID;
    }

    public Stats getConstStats() {
        return constStats;
    }

    public Stats getDynamicStats() {
        return dynamicStats;
    }

    public Set<Being> getSurroundingBeings() {
        return Supervisor.getSupervisor().getSurroundingBeings(this, constStats.get(StatType.C_VISION_RADIUS).getValue());
    }

    public Being bear() {
        dynamicStats.get(StatType.D_EATEN).addToValue(-30.0);
        int newClassID = WorldPhysics.nextID();
        return new CellCreature(new Point3(pos), constStats.mutateClone(), childDynamicStats.clone(), newClassID);
    }
    
    public Being split() {
        dynamicStats.get(StatType.D_EATEN).addToValue(-30.0);
        return new CellCreature(new Point3(pos), constStats, childDynamicStats.clone(), classID);
    }

    public boolean isAlive() {
        return dynamicStats.get(StatType.D_HEALTH).getValue() > 0;
    }

    public boolean childReady() {
        return dynamicStats.get(StatType.D_EATEN).getValue() >= 30.0;
    }

    public void moveTo(Point3 p) {
        pos.add(p.minus(pos));        
        //System.out.println("Gone to " + p);
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    public Point3 getPosition() {
        return pos;
    }

    @Override
    public String toString(){
        return "CellCreature("+ID+")";
    }

    private Point3 pos;
    private AIModule ai;
    private Stats constStats;
    private Stats dynamicStats;
    private Stats childDynamicStats;
    private ObstacleType obstacleType;
    private final int ID;
    private int classID;
}
