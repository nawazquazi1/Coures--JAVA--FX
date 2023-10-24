package application;

public class PowerFunction extends Function {

    public PowerFunction(double a, double b) {
        super(a, b);
    }

    @Override
    public double getY(double x){
        return getB() * Math.pow(x,getA());
    }

    @Override
    public String toString() {
        return "f(x)=" + df.format(getB()) + "*x^" + df.format(getA());
    }
}