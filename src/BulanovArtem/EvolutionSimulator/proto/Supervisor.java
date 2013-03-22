package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.Being;
import BulanovArtem.EvolutionSimulator.Obstacle;
import BulanovArtem.EvolutionSimulator.Point3;

import javax.swing.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Supervisor
 * User: aielemental
 * Date: 21.09.12
 * Time: 13:29
 */
//todo add description
public class Supervisor {
    public static void update(){
        if (draw != null) {
            draw.repaint();
        }
    }
    public static Supervisor getSupervisor(){
        return instance;
    }

    public void registerBeing(Being b){
        beings.add(b);
        Thread t = new Thread(b.getAI());
        t.start();
        //System.out.println(beings.size());
    }

    public void deregisterBeing(Being b) {
        beings.remove(b);
    }

    public static void registerFrame(JFrame jf){
        draw = jf;
    }

    public Set<Being> getSurroundingBeings(Being base, double radius){
        Set<Being> surroundingBeings = new HashSet<Being> ();
        synchronized (beings) {
            for (Being being : beings){
                if (base.getPosition().isInRadius(being.getPosition(), radius) && base != being) {
                    surroundingBeings.add(being);
                }
            }
        }
        return surroundingBeings;
    }

    public Set<Being> getBeings() {
        return new HashSet<Being>(beings);
    }
    
    public Set<Point3> getAlivePositions() {
        Set<Point3> points = new HashSet<Point3>();
        synchronized (beings) {
            for (Being b : beings) {
                points.add(new Point3(b.getPosition()));
            }               
        }
        return points;
    }

    private static final Supervisor instance = new Supervisor();
    private final Set<Being> beings = Collections.synchronizedSet(new HashSet<Being>());    
    private static JFrame draw;
    private Supervisor(){}
}
