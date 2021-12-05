package ru.avalon.javapp.devj110.rectangleMethodTwoDimensional;

public class Main {

    public static void main(String[] args) {
        Function f1 = new F1();    // вложенный класс
        System.out.println(rectangleMethod(f1, 1, 3, 1, 3));
        
        Function f2 = new Function() { // анонимный класс
        public double f(double x, double y) {
        return (x*x+x)*(2*y+1);
        }       
        };
        System.out.println(rectangleMethod(f2, 3, 4, 7, 10));
        
        Function f3 = Function::staticMeth;      // статический метод
        System.out.println(rectangleMethod(f3, 0.01, 2, 0.5, 4));
        
        F4 func4 = new F4();    // ссылка на метод экземпляра
        Function f4 = func4::x2PlusY3;
        System.out.println(rectangleMethod(f4, 1, 3, 1, 2));
        
        Function f5 = (double x, double y) -> x*y*Math.sin(x*y); // лямбда выражение
        System.out.println(rectangleMethod(f5, 0, 1, 0, 1));
        
    }

    private static final int PARTS = 100;

    public static double rectangleMethod (Function function, double leftX, double rightX, double leftY, double rightY){
        double v = 0;

            
            double stepX = (rightX - leftX)/100; // шаг x
            double stepY = (rightY - leftY)/100; // шаг y
            for(int i=0; i<PARTS; i++) {
                leftX += stepX; // увеличение x на шаг
                double tempY =leftY; // временная переменная y = нач y
                for(int j=0; j<PARTS; j++) {
                    tempY += stepY; // увеличение временной y на шаг
                    double s = stepX*stepY*function.f(leftX - stepX/2 , tempY - stepY/2); 
                    v += s; 
                }
            }return v;
          
        }
    
    
     private static class F1 implements Function { // вложенный класс
        @Override
        public double f(double x, double y) {
            return x*y;
        }
    }
}
