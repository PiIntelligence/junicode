package de.pi_intelligence.perfect_draw;

/**
 * Created by moe on 25/05/16.
 */
public class Bounds {

    private double left = 0d, bottom = 0d, right = 0d, top = 0d;
    private Point offset = new Point(0d, 0d);

    public Bounds() {
    }


    public void offset(double x, double y) {
        if (x != 0d)
            offset.setX(offset.getX() + x);
        if (y != 0d)
            offset.setY(offset.getY() + y);
    }

    public Bounds(double left, double bottom, double right, double top, Point offset) {

        this.left = left;
        this.bottom = bottom;
        this.right = right;
        this.top = top;
        this.offset = offset;
    }

    public Bounds(double left, double bottom, double right, double top) {

        this.left = left;
        this.bottom = bottom;
        this.right = right;
        this.top = top;
    }

    public Point getOffset() {
        return this.offset;
    }

    public void setOffset(Point offset) {
        if (offset == null) {
            this.offset.setX(0);
            this.offset.setY(0);
            return;
        }
        this.offset = offset;

    }

    public double getX() {
        return offset.getX();
    }

    public void setX(double x) {
        this.offset.setX(x);
    }

    public double getY() {
        return this.offset.getY();

    }

    public void setY(double y) {
        this.offset.setY(y);
    }

    public double getHeight() {
        return top - bottom;
    }

    public double getWidth() {
        return right - left;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right2) {
        this.right = right2;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }
}
