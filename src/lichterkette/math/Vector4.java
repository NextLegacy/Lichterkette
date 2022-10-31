package lichterkette.math;

/** Code from https://github.com/NextLegacy/Engine/tree/master/src/engine/window/Input */
public abstract class Vector4
{
    protected Vector4(double x, double y, double z, double w) { this.x = x; this.y = y; this.z = z; this.w = w; }

    protected double x;
    protected double y;
    protected double z;
    protected double w;

    public final double x() { return x; }
    public final double y() { return y; }
    public final double z() { return z; }
    public final double w() { return w; }

    public final int int_x() { return (int) x; }
    public final int int_y() { return (int) y; }
    public final int int_z() { return (int) z; }
    public final int int_w() { return (int) w; }

    public final Vector times    (Vector4 vector) { return times    (vector.x, vector.y, vector.z); }
    public final Vector dividedBy(Vector4 vector) { return dividedBy(vector.x, vector.y, vector.z); }
    public final Vector plus     (Vector4 vector) { return plus     (vector.x, vector.y, vector.z); }
    public final Vector minus    (Vector4 vector) { return minus    (vector.x, vector.y, vector.z); }

    public final Vector times    (double n) { return times    (n, n, n); }
    public final Vector dividedBy(double n) { return dividedBy(n, n, n); }
    public final Vector plus     (double n) { return plus     (n, n, n); }
    public final Vector minus    (double n) { return minus    (n, n, n); }

    public final Vector times    (double x, double y) { return times    (x, y, 1); }
    public final Vector dividedBy(double x, double y) { return dividedBy(x, y, 1); }
    public final Vector plus     (double x, double y) { return plus     (x, y, 0); }
    public final Vector minus    (double x, double y) { return minus    (x, y, 0); }

    public final Vector times    (double x, double y, double z) { return new Vector(this.x * x, this.y * y, this.z * z, w); }
    public final Vector dividedBy(double x, double y, double z) { return new Vector(this.x / (x==0?1:x), this.y / (y==0?1:y), this.z / (z==0?1:z), w); }
    public final Vector plus     (double x, double y, double z) { return new Vector(this.x + x, this.y + y, this.z + z, w); }
    public final Vector minus    (double x, double y, double z) { return new Vector(this.x - x, this.y - y, this.z - z, w); }

    public abstract Vector inverted  ();
    public abstract Vector normalized();
    public abstract double magnitude ();
    public abstract Vector angle     ();

    public final double angleTo(Vector4 vec) 
    { 
        double m = magnitude() * vec.magnitude();
        double a = dot(vec);

        if (m != 0) a /= m;
        
        return Math.acos(a);
    }
    
    public final double dot(Vector4 vec) { return x * vec.x + y * vec.y + z * vec.z; }

    public final Vector cross(Vector4 v) 
    { 
        return new Vector(
            y * v.z - z * v.y,
            z * v.x - x * v.z,
            x * v.y - y * v.x
        );
    }

    public final double distanceTo(Vector4 vector) { return this.minus(vector).magnitude(); }

    public final Vector directionTo(Vector4 vector)
    {
        return vector.minus(this).normalized();
    }

    public final FinalVector toFinalVector() { return this instanceof FinalVector finalVector ? finalVector : new FinalVector(x, y, z, w); }
    public final Vector      toVector     () { return new Vector(x, y, z, w); } //creates a clone

    public final boolean XisInRange(double min, double max) { return x >= min && x <= max; }
    public final boolean YisInRange(double min, double max) { return y >= min && y <= max; }
    public final boolean ZisInRange(double min, double max) { return z >= min && z <= max; }
    public final boolean isInRange(Vector4 from, Vector4 to) { return XisInRange(from.x, to.x) && YisInRange(from.y, to.y) && ZisInRange(from.z, to.z); }

    public final boolean XisInBounds(double n, double length) { final double halfLength = length / 2; return XisInRange(n - halfLength, n + halfLength); }
    public final boolean YisInBounds(double n, double length) { final double halfLength = length / 2; return YisInRange(n - halfLength, n + halfLength); }
    public final boolean ZisInBounds(double n, double length) { final double halfLength = length / 2; return ZisInRange(n - halfLength, n + halfLength); }
    public final boolean isInBounds(Vector4 position, Vector4 size) { return XisInBounds(position.x, size.x) && YisInBounds(position.y, size.y) && ZisInBounds(position.z, size.z); }

    public final boolean isOutOfRange(Vector4 from, Vector4 to) { return !isInRange(from, to); }
    public final boolean isOutOfBounds(Vector4 position, Vector4 size) { return !isInBounds(position, size); }

    public final boolean equals(Vector4 vector)
    {
        return vector != null && x == vector.x && y == vector.y && z == vector.z;
    }

    public final boolean equals(Object object)
    {
        if (object == null) return false;

        return object == null ? false :
               this == object                     || 
               (object instanceof Vector4 vector) && 
               equals(vector);
    }

    public final String toCompactString()
    {
        return "x: " + x + ", y: " + y + ", z: " + z + ", w: " + w;
    }

    public final String toString()
    {
        return getClass().getSimpleName() + "(" + toCompactString() + ")";
    }
}
