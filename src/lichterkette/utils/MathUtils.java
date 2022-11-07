package lichterkette.utils;

public final class MathUtils 
{
    private MathUtils() { }

    public static boolean isInRange(double n, double min, double max) { return n >= min && n <= max; }
    public static boolean IsNotInRange(double n, double min, double max) { return !isInRange(n, min, max); }
}
