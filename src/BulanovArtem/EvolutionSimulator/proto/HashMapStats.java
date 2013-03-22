package BulanovArtem.EvolutionSimulator.proto;

import BulanovArtem.EvolutionSimulator.Random;
import BulanovArtem.EvolutionSimulator.Stat;
import BulanovArtem.EvolutionSimulator.StatType;
import BulanovArtem.EvolutionSimulator.Stats;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMapStats
 * User: aielemental
 * Date: 21.09.12
 * Time: 13:03
 */
//todo add description
public class HashMapStats implements Stats{
    
    public HashMapStats(){
        stats = new HashMap<StatType, Stat>(8);
    }
    public Stat get(StatType s) {
        return stats.get(s);
    }    
    public void put(Stat s) {
        if (!stats.containsKey(s.getType())) {
            stats.put(s.getType(), s);
        }
    }
    public Stats clone() {
        HashMapStats myClone = new HashMapStats();
        for (Stat stat : stats.values()) {
            myClone.put(new Stat(stat.getType(), stat.getValue()));
        }
        return myClone;
    }

    public Stats mutateClone() {
        HashMapStats myClone = new HashMapStats();
        for (Stat stat : stats.values()) {
            myClone.put(new Stat(stat.getType(), stat.getValue() * Random.getGaussian(0.5, 1.5)));
        }
        return myClone;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Map.Entry e : stats.entrySet()){
            res.append("<");
            res.append(e.getKey());
            res.append(" = ");
            res.append(e.getValue());
            res.append(">");
        }
        return res.toString();
    }

    private Map<StatType, Stat> stats;
}
