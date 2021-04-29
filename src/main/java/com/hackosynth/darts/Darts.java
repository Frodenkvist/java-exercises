package com.hackosynth.darts;

public class Darts {
    /**
     * Given the x and y coordinates returns the score a dart landing there would yield
     * @param x - the X coordinate
     * @param y - the Y coordinate
     * @return the score the given coordinates would yield
     */
    public static int score(double x, double y) {
        double radius = Math.sqrt(x * x + y * y);

        if(radius <= 1.0D) return 10;
        if(radius <= 5.0D) return 5;
        if(radius <= 10.0D) return 1;
        return 0;
    }
}
