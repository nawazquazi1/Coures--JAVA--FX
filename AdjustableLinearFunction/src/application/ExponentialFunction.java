package application;

public class ExponentialFunction extends Function{

    public ExponentialFunction(double a, double b) {
        super(a, b);
    }

    @Override
    public double getY(double x) {
        return getB() * Math.pow(getA(),x);
    }

    @Override
    public String toString() {
        return "f(x)=" + df.format(getB()) + "*" + df.format(getA()) + "^x";
    }
}