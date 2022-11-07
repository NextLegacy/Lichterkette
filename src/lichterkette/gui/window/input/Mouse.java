package lichterkette.gui.window.input;

import lichterkette.math.Vector;

public final class Mouse
{
    boolean INSIDE;

    Vector POSITION_BEFORE;
    Vector POSITION_NOW;

    Mouse()
    {
        INSIDE = false;

        POSITION_BEFORE = Vector.zero();
        POSITION_NOW    = Vector.zero();
    }

    public boolean isInside() { return INSIDE; }

    public Vector position() { return POSITION_NOW.clone(); }
    public Vector speed   () { return POSITION_NOW.minus(POSITION_BEFORE); }

    public boolean isInRange(Vector from, Vector to)
    {
        return position().isInRange(from, to);
    }

    public boolean isInBounds(Vector position, Vector size)
    {
        return position().isInBounds(position, size);
    }
}