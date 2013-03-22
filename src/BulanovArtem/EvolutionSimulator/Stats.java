package BulanovArtem.EvolutionSimulator;

/**
 * Stats
 * User: aielemental
 * Date: 19.09.12
 * Time: 15:12
 */
//todo add description
public interface Stats {
    Stat get(StatType s);
    void put(Stat s);
    Stats clone();
    Stats mutateClone();
}
