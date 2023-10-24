package application;

import java.text.DecimalFormat;

public abstract class Function {

    private double a;
    private double b;

    DecimalFormat df = new DecimalFormat("#.00");

    public Function(double a, double b) {
        this.a = a;
        this.b = b;
    }

    abstract public double getY(double x);

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}