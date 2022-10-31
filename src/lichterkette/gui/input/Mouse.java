package lichterkette.gui.input;

import lichterkette.math.FinalVector;
import lichterkette.math.Vector;
import lichterkette.math.Vector4;

/** Code from https://github.com/NextLegacy/Engine/tree/master/src/engine/window/Input */
public final class Mouse
{
    public static FinalVector UNDEFINED_POSITION = new FinalVector(-1, -1);

    FinalVector POSITION_BEFORE;
    FinalVector POSITION_NOW;

    Mouse()
    {
        POSITION_BEFORE = FinalVector.zero;
        POSITION_NOW    = FinalVector.zero;
    }

    public FinalVector position() { return POSITION_NOW; }
    public Vector      speed   () { return POSITION_NOW.minus(POSITION_BEFORE); }


    public boolean isInRange(Vector4 from, Vector4 to)
    {
        return position().isInRange(from, to);
    }

    public boolean isInBounds(Vector4 position, Vector4 size)
    {
        return position().isInBounds(position, size);
    }
}