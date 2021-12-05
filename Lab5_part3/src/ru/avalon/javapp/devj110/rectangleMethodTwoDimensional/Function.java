package ru.avalon.javapp.devj110.rectangleMethodTwoDimensional;

public interface Function {
    double f(double x, double y);
        
    public static double staticMeth(double x, double y) {
        return Math.exp(-x*y);
    }
    
    
}
