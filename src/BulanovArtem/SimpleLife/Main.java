package BulanovArtem.SimpleLife;

import java.util.ArrayList;
import java.util.List;

/**
 * Main
 * User: aielemental
 * Date: 14.03.13
 * Time: 11:59
 */
//todo add description
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SimpleCreature adam = new SimpleCreature(100.0);
        List<SimpleCreature> list = new ArrayList<SimpleCreature>();
        list.add(adam);
        List<SimpleCreature> newBorn;
        while (true) {
            newBorn = new ArrayList<SimpleCreature>();
            for (SimpleCreature creature : list) {
                creature.eat(new SimpleCreature(10.0));
                if (creature.foodLevel > 200.0) {
                    newBorn.add(creature.bear());
                }
            }
            list.addAll(newBorn);
            System.out.println(list.size());
            Thread.sleep(100);
        }
    }
}
