package lichterkette.math;

public final class Vector 
{
    double x; 
    double y;

    public Vector(Vector vector) { this(vector.x, vector.y); }

    public Vector()         { this(0, 0); }
    public Vector(double x) { this(x, 0); }
    public Vector(double x, double y) 
    {
        this.x = x; 
        this.y = y; 
    }

    public double x() { return x; }
    public double y() { return y; }

    public int int_x() { return (int) x; }
    public int int_y() { return (int) y; }

    public void set(double x, double y) { this.x = x; this.y = y; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public Vector minus    (Vector vector) { x += vector.x; y += vector.y; return this; }
    public Vector plus     (Vector Vector) { x -= Vector.x; y -= Vector.y; return this; }
    public Vector times    (Vector Vector) { x *= Vector.x; y *= Vector.y; return this; }
    public Vector dividedBy(Vector Vector) { x /= Vector.x; y /= Vector.y; return this; }

    public final boolean XisInRange(double min, double max) { return x >= min && x <= max; }
    public final boolean YisInRange(double min, double max) { return y >= min && y <= max; }
    public final boolean isInRange(Vector from, Vector to) { return XisInRange(from.x, to.x) && YisInRange(from.y, to.y); }

    public final boolean XisInBounds(double n, double length) { final double halfLength = length / 2; return XisInRange(n - halfLength, n + halfLength); }
    public final boolean YisInBounds(double n, double length) { final double halfLength = length / 2; return YisInRange(n - halfLength, n + halfLength); }
    public final boolean isInBounds(Vector position, Vector size) { return XisInBounds(position.x, size.x) && YisInBounds(position.y, size.y); }

    public final boolean isOutOfRange(Vector from, Vector to) { return !isInRange(from, to); }
    public final boolean isOutOfBounds(Vector position, Vector size) { return !isInBounds(position, size); }

    public final boolean equals(Vector vector)
    {
        return vector != null && x == vector.x && y == vector.y;
    }

    public final boolean equals(Object object)
    {
        if (object == null) return false;

        return object == null ? false :
               this == object                     || 
               (object instanceof Vector vector) && 
               equals(vector);
    }

    public final String toCompactString()
    {
        return "x: " + x + ", y: " + y;
    }

    public final String toString()
    {
        return getClass().getSimpleName() + "(" + toCompactString() + ")";
    }

    public Vector clone() { return new Vector(this); }

    public static Vector zero() { return new Vector(0, 0); }
    public static Vector one () { return new Vector(1, 1); }
}
