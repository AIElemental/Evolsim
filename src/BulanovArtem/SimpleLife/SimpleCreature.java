package BulanovArtem.SimpleLife;

/**
 * SimpleCreature
 * User: aielemental
 * Date: 14.03.13
 * Time: 11:53
 */
//todo add description
public class SimpleCreature {    
    public void eat(SimpleCreature food) {
        foodLevel += food.foodLevel;
        food.die();
    }
    public void die() {
        alive = false;
    }
    public SimpleCreature bear() {
        foodLevel /= 2;
        SimpleCreature clone = new SimpleCreature(foodLevel);
        return clone;
    }
    public SimpleCreature(double startingFoodLevel) {
        foodLevel = startingFoodLevel;
    }

    public double foodLevel;
    private boolean alive = true;
}
