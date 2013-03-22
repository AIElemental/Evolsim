package BulanovArtem.EvolutionSimulator;

/**
 * Obstacle
 * User: aielemental
 * Date: 19.09.12
 * Time: 15:12
 */
//todo add descriptionpackage BulanovArtem.EvolutionSimulator;
public interface Obstacle {
    ObstacleType getObstacleType();
    Point3 getPosition();
}
