package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.*;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Main
 * User: aielemental
 * Date: 14.07.12
 * Time: 14:33
 */
//todo add description
public class Main {
    public static JFrame initWindow(){
        final JFrame jFrame = new JFrame("Cell view"){
            @Override            
            public void paint(Graphics g) {
                draw(g);
            }
            @Override
            public void update(Graphics g) {
                 draw(g);
            }
            
            private void draw(Graphics g) {                
                //Point3 p;
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.GREEN);
                //Set<Being> set = Supervisor.getSupervisor().getBeings();
                Set<Point3> set = Supervisor.getSupervisor().getAlivePositions();
                for (Point3 p : set){
                    //System.out.print(p);
                    //if (being.isAlive()) {
//                        g.setColor(Color.GREEN);
                        g.fillRect((int) p.getX() - 2 + getWidth() / 2, (int) p.getY() - 2 + getHeight() / 2, 4, 4);
//                    } else {
//                        g.setColor(Color.RED);
//                        g.drawRect((int) p.getX() - 1 + getWidth() / 2, (int) p.getY() - 1 + getHeight() / 2, 2, 2);
//                    }
                }
                //System.out.println();
            }
        };
        jFrame.setSize(400,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return jFrame;
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame view = initWindow();
        Supervisor.registerFrame(view);

        Stats constStatsInit = new HashMapStats();

        constStatsInit.put(new Stat(StatType.C_CREATURE_CLASS, 1.0));
        constStatsInit.put(new Stat(StatType.C_ATTACK, 10.0));
        constStatsInit.put(new Stat(StatType.C_MAX_HEALTH, 100.0));
        constStatsInit.put(new Stat(StatType.C_VISION_RADIUS, 2000.0));
        
        Stats dynamicStatsInit = new HashMapStats();
        dynamicStatsInit.put(new Stat(StatType.D_HEALTH, 100.0));
        dynamicStatsInit.put(new Stat(StatType.D_HUNGER, 30.0));
        dynamicStatsInit.put(new Stat(StatType.D_EATEN, 10.0));
        
        CellCreature cc;
        int seed = 40;
        int initialCreatureCount = 1;
        for (int i = 0; i < initialCreatureCount; i++) {
            double x = -150 + 300 / initialCreatureCount * i; //Random.getGaussian()*seed - seed/2;
            double y = Random.getGaussian(-200, 200); //Random.getGaussian()*seed - seed/2;
            cc = new CellCreature(new Point3(x, y, 0), constStatsInit, dynamicStatsInit.clone(), WorldPhysics.nextID());
            Supervisor.getSupervisor().registerBeing(cc);
        }
        while (true) {
            if (Supervisor.getSupervisor().getBeings().size() < 2) {
                double x = Random.getGaussian(-200, 200);
                double y = Random.getGaussian(-200, 200);
                cc = new CellCreature(new Point3(x, y, 0), constStatsInit, dynamicStatsInit.clone(), WorldPhysics.nextID());
                Supervisor.getSupervisor().registerBeing(cc);
            }
            Supervisor.update();
            Thread.sleep(500);
        }
    }
}
