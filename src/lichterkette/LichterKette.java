package lichterkette;

import java.util.ArrayList;

public class LichterKette 
{
    private ArrayList<LED> lichterkette;

    public LichterKette()
    {
        lichterkette = new ArrayList<>();
    }

    public int getSize(){
        return lichterkette.size();
    }

    public void setSize(int newSize)
    {
        if(newSize>lichterkette.size())
        {
            for(int i=lichterkette.size();i<newSize;i++)
            {
                lichterkette.add(new LED());
            }
        }
        else
        {
            int j=lichterkette.size();
            for(int i=j-1;i>=newSize;i--)
            {
                lichterkette.remove(i);
            }
        }
    }

    /**
     * Activates LED
     * @param index Index of the LED that should be activated
     */
    public void setRGB(int index, int color)
    {
        lichterkette.get(index).setRGB(color);
    }

    /**
     * Activates LED at given Index
     * @param index Index of the LED that should be activated
     * @param state State that the LEDs should be set to
     */
    public void setActive(int index, boolean state)
    {
        lichterkette.get(index).setActive(state);
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
    public void setActiveMultiple(int position, int length, boolean state)
    {
        if(length == 0) return;
        if(position < 0) position = lichterkette.size() + position;
        if(length < 0) 
        {
            position = position + length + 1;
            length = length * -1;
        }
            for(int i=0;i<length;i++)
            {
                if(position+i >= lichterkette.size())
                {
                    setActive(position+i,state);
                }
                else
                {
                    setActive((position+i)-lichterkette.size(),state);
                }
            }
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
        if (position >= lichterkette.size() || gapSize == 0)
        {
            System.out.println("Ausführung nicht möglich.");
        }
        else
        {
            for(int i = 1; i <= (length/gapSize); i ++)
            {
                setActive(position - 1 + (gapSize * i) ,state);
            }
        }

        
    } 
}
