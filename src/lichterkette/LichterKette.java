package lichterkette;

import java.util.ArrayList;

/**
 * Simple LichterKette Class, used to simulate a strip of LEDs
 * 
 * @author XrossXross
 * @author Verodox
 * @author bbddvv
 * @author NextLegcy 
 */
public class LichterKette 
{
    private ArrayList<LED> list;

    public LichterKette()
    {
        list = new ArrayList<>();
    }

    /**
     * @return size of the LichterKette
     */
    public int getSize()
    {
        return list.size();
    }
    
    /**
     * Resizes the LichterKette
     * @param newSize new size for the LichterKette
     */
    public void setSize(int newSize)
    {
        ArrayList<LED> tmp = new ArrayList<LED>(newSize);

        for(int i = 0; i< list.size() && i < newSize; i ++)
            tmp.set(i, list.get(i));

        for(int i = list.size(); i < newSize; i++)
            tmp.set(i, new LED());

        list = tmp;
    }

    /**
     * Activates LED at given Index
     * @param index Index of the LED that should be activated
     * @param state State that the LEDs should be set to
     */
    public void setActive(int index, boolean state)
    {
        list.get(index).setActive(state);
    }

    /**
     * Activates Multiple LEDs
     * <pre>{@code Example:
     *     +----------------------------------------------------------------------------+
     *     |                                          length                            |    
     *     |                                          ---->                             |    
     *     |  [o, o, o, o, o, o] | ( 2,  2) => [o, o, S, S, o, o] | o = old & S = state |
     *     |                                    ------>                                 |
     *     |                                    position                                | 
     *     +----------------------------------------------------------------------------+
     * 
     *     +----------------------------------------------------------------------------+
     *     |                                            length                          |
     *     |                                            <----                           |
     *     |  [o, o, o, o, o, o] | (-2, -2) => [o, o, o, S, S, o] | o = old & S = state |
     *     |                                                <---                        | 
     *     |                                             position                       |  
     *     +----------------------------------------------------------------------------+
     * }</pre>
     * @param position Position to start from
     * @param length The length
     * @param state State that the LEDs should be set tos
    */
    public void setActiveMultiple(int position, int length, boolean state)
    {
        if(length == 0) return;
        if(position < 0) position = list.size() + position;
        if(length < 0) 
        {
            position = position + length + 1;
            length = length * -1;
        }
            for(int i=0;i<length;i++)
            {
                if(position+i >= list.size())
                {
                    setActive(position+i, state);
                }
                else
                {
                    setActive((position+i)-list.size(), state);
                }
            }
    }

    /**
     * Activates LEDs in with gaps
     * <pre>{@code Example:
     * +------------------------------------------------------------------------+
     * |  [o, o, o, o, o, o] | (1) => [o, S, o, S, o, S] | o = old & S = state  |
     * +------------------------------------------------------------------------+
     * }</pre>
     * @param gapSize The gapSize
     * @param state State that the LEDs should be set to
     */
    public void setActiveInGaps(int gapSize, boolean state)
    {
        for(int i = gapSize; i < list.size(); i += gapSize+1)
        {
            setActive(i, state);
        }
    }  

    /**
     * Activates LEDs in with gaps from 
     * <pre>{@code Example:
     * +------------------------------------------------------------------------------+
     * |                                             length                           |
     * |                                           --------->                         |
     * |  [o, o, o, o, o, o] | (2, 4, 1) => [o, o, S, o, S, o] | o = old & S = State  |
     * |                                     ------>                                  |
     * |                                     position                                 |
     * +------------------------------------------------------------------------------+
     * }</pre>
     * @param position Position from where to start from
     * @param length The Length 
     * @param gapSize The GapSize
     * @param state State that the LEDs should be set to
     */
    public void setActiveInGaps(int position, int length, int gapSize, boolean state)
    {
        if (position >= list.size() || gapSize == 0)
        {
            System.out.println("Ausführung nicht möglich.");
        }
        else
        {  
            for (int i = position; i <= length; i += gapSize+1)
            {
                setActive(i, state);
            }
        }
    }

    /**
     * Activates LED
     * @param index Index of the LED that should be activated
     */
    public void setRGB(int index, int rgb)
    {
        list.get(index).setRGB(rgb);
    }

    /**
     * Activates Multiple LEDs
     * <pre>{@code Example:
     *     +----------------------------------------------------------------------------+
     *     |                                          length                            |    
     *     |                                          ---->                             |    
     *     |  [o, o, o, o, o, o] | ( 2,  2) => [o, o, R, R, o, o] | o = old & R = rgb   |
     *     |                                    ------>                                 |
     *     |                                    position                                | 
     *     +----------------------------------------------------------------------------+
     * 
     *     +----------------------------------------------------------------------------+
     *     |                                            length                          |
     *     |                                            <----                           |
     *     |  [o, o, o, o, o, o] | (-2, -2) => [o, o, o, R, R, o] | o = old & R = rgb   |
     *     |                                                <---                        | 
     *     |                                             position                       |  
     *     +----------------------------------------------------------------------------+
     * }</pre>
     * @param position Position to start from
     * @param length The length
     * @param state State that the LEDs should be set tos
    */
    public void setRGBMultiple(int position, int length, int rgb)
    {
        if(length == 0) return;
        if(position < 0) position = list.size() + position;
        if(length < 0) 
        {
            position = position + length + 1;
            length = length * -1;
        }

        for(int i=0;i<length;i++)
        {
            if(position+i >= list.size())
            {
                setActive(position+i, state);
            }
            else
            {
                setActive((position+i)-list.size(), state);
            }
        }
    }

    /**
     * Activates LEDs in with gaps
     * <pre>{@code Example:
     * +------------------------------------------------------------------------+
     * |  [o, o, o, o, o, o] | (2) => [o, R, o, R, o, R] | o = old & R = rgb    |
     * +------------------------------------------------------------------------+
     * }</pre>
     * @param gapSize The gapSize
     * @param state State that the LEDs should be set to
     */
    public void setRGBInGaps(int gapSize, boolean state)
    {
        for(int i = gapSize; i < list.size(); i += gapSize)
        {
            setActive(i, state);
        }
    }  

    /**
     * Activates LEDs in with gaps from 
     * <pre>{@code Example:
     * +------------------------------------------------------------------------------+
     * |                                             length                           |
     * |                                           --------->                         |
     * |  [o, o, o, o, o, o] | (2, 4, 1) => [o, o, R, o, R, o] | o = old & R = rgb    |
     * |                                     ------>                                  |
     * |                                     position                                 |
     * +------------------------------------------------------------------------------+
     * }</pre>
     * @param position Position from where to start from
     * @param length The Length 
     * @param gapSize The GapSize
     * @param state State that the LEDs should be set to
     */
    public void setRGBInGaps(int position, int length, int gapSize, int rgb)
    {
        if (position >= list.size() || gapSize == 0)
        {
            System.out.println("Ausführung nicht möglich.");
        }
        else
        {  
            for (int i = position; i <= length; i += gapSize+1)
            {
                setActive(i, state);
            }
        }
    }
}
