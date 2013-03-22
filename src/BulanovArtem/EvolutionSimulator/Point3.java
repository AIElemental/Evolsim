package BulanovArtem.EvolutionSimulator;

import static java.lang.Math.sqrt;

/**
 * Point3
 * User: aielemental
 * Date: 14.07.12
 * Time: 14:29
 */
//todo add description
public class Point3 {
    private double x,y,z;
    
    public Point3 add(Point3 p){
        this.x += p.x;
        this.y += p.y;
        this.z += p.z;
        return this;
    }
    
    public Point3 neg(){
        x = -x;
        y = -y;
        z = -z;
        return this;
    }
    
    public Point3 minus(Point3 p){
        return new Point3(this.x - p.x, this.y - p.y, this.z - p.z);
    }
    
    public Point3 plus(Point3 p){
        return new Point3(this.x + p.x, this.y + p.y, this.z + p.z);
    }
    public Point3 multiply(double multiplier) {
        x *= multiplier;
        y *= multiplier;
        z *= multiplier;
        return this;
    }
    public double modulo(){
        return sqrt(x*x + y*y + z*z);
    }
    public void normalize() {
        if (x != 0.0 || y != 0.0 || z != 0.0) {
            double modulo = modulo();
            x /= modulo;
            y /= modulo;
            z /= modulo;
        }
    }
    
    public boolean isInRadius(Point3 p, double radius){
        return this.minus(p).modulo() < radius;
    }
    

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Point3(double xd, double yd, double zd){
        x = xd;
        y = yd;
        z = zd;
    }
    public Point3(double xd, double yd){
        x = xd;
        y = yd;
        z = 0.0;
    }
    public Point3(double xd){
        x = xd;
        y = 0.0;
        z = 0.0;
    }
    public Point3(Point3 origin){
        x = origin.x;
        y = origin.y;
        z = origin.z;
    }

    @Override
    public String toString() {
        return "("+x+","+y+","+z+")";
    }
}
