package BulanovArtem.EvolutionSimulator;

/**
 * Stat
 * User: aielemental
 * Date: 19.03.13
 * Time: 13:09
 */
//todo add description
public class Stat {
    public StatType getType() {
        return type;
    }
    public double getValue() {
        return value;
    }
    public void addToValue(double term) {
        value += term;
    }
    public Stat(StatType inType, double inValue) {
        type = inType;
        value = inValue;
    }

    private StatType type;
    private double value;

}
