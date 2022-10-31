package lichterkette;

import java.util.ArrayList;

public class LichterKette 
{
    private ArrayList<LED> lichterkette;

    public LichterKette()
    {
        lichterkette = new ArrayList<>();
    }

    /**
     * Activates LED
     * @param index Index of the LED that should be activated
     */
    public void setRGB(int index, int color)
    {
        throw new RuntimeException("Not Implemented Yet");
    }

    /**
     * Activates LED at given Index
     * @param index Index of the LED that should be activated
     * @param state State that the LEDs should be set to
     */
    public void setActive(int index, boolean state)
    {
        throw new RuntimeException("Not Implemented Yet");
    }

    /**
     * Activates Multiple LEDs
     * <pre>{@code Example:
     *     +--------------------------------------------------------------------------------------+
     *     |                                           length                                     |    
     *     |                                           ---->                                      |    
     *     |   [o, o, o, o, o, o] | ( 2,  2) => [o, o, S, S, o, o] | o = old & S = state          |
     *     |                                     ------>                                          |
     *     |                                     position                                         | 
     *     +--------------------------------------------------------------------------------------+
     * 
     *     +--------------------------------------------------------------------------------------+
     *     |                                             length                                   |
     *     |                                             <----                                    |
     *     |   [o, o, o, o, o, o] | (-2, -2) => [o, o, o, S, S, o] | o = old & S = state          |
     *     |                                                 <---                                 | 
     *     |                                              position                                |  
     *     +--------------------------------------------------------------------------------------+
     * }</pre>
     * @param position Position to start from
     * @param length The length
     * @param state State that the LEDs should be set tos
    */
    public void setActiveMultiple(int position, int length, int state)
    {
        throw new RuntimeException("Not Implemented Yet");
    }

    /**
     * Activates LEDs in with gaps
     * <pre>{@code Example:
     * +--------------------------------------------------------------------------------------+
     * |   [o, o, o, o, o, o] | (2) => [o, S, o, S, o, S] | o = inactive & S = state          |
     * +--------------------------------------------------------------------------------------+
     * }</pre>
     * @param gapSize The gapSize
     * @param state State that the LEDs should be set to
     */
    public void setActiveInGaps(int gapSize, boolean state)
    {
        for(int i = gapSize; i < lichterkette.size(); i += gapSize)
        {
            setActive(i, state);
        }
    }  

    /**
     * Activates LEDs in with gaps from 
     * <pre>{@code Example:
     * +--------------------------------------------------------------------------------------+
     * |                                        length                                        |
     * |                                      --------->                                      |
     * |   [o, o, o, o, o, o] | (2, 4) => [o, o, S, o, S, o] | o = old & S = State            |
     * |                                ------>                                               |
     * |                                position                                              |
     * +--------------------------------------------------------------------------------------+
     * }</pre>
     * @param position Position from where to start from
     * @param length The Length 
     * @param gapSize The GapSize
     * @param state State that the LEDs should be set to
     */
    public void setActiveInGaps(int position, int length, int gapSize, boolean state)
    {
        throw new RuntimeException("Not Implemented Yet");
    } 
}
