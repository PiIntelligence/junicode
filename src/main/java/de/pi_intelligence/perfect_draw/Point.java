package de.pi_intelligence.perfect_draw;

/**
 * Created by moe on 25/05/16.
 */
public class Point {

    private double x,y;
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

    public Point(double x, double y) {

        this.x = x;
        this.y = y;
    }

}
