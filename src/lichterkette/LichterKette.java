package lichterkette;

import java.util.ArrayList;
import java.util.Collection;

import engine.utils.Lambda.Action1;

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
     * Removes the element at the specified position in this LichterKette.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public LED remove(int index)
    {
        return list.remove(index);
    }

    /**
     * Removes the first occurrence of the specified elements from this list,
     * if it is present.  If the LichterKette does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).
     *
     * @param leds elements to be removed from this list, if present
     */
    public void remove(LED... leds)
    {
        for (LED led : leds)
            if (led != null)
                list.remove(led);
    }

    /**
     * Returns the led at the specified position in this list.
     *
     * @param  index index of the led to return
     * @return the led at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public LED get(int index)
    {
        return list.get(index);
    }

    /**
     * Appends the specified elements to the end of this list.
     *
     * @param leds elements to be appended to this list
     */
    public void add(LED... leds)
    {
        for (LED led : leds)
            if (led != null)
                list.add(led);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this LichterKette, in the order that they are returned by the
     * specified collection's Iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the operation
     * is in progress.  (This implies that the behavior of this call is
     * undefined if the specified collection is this list, and this
     * list is nonempty.)
     *
     * @param collection collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(Collection<LED> listToAdd)
    {
        return list.addAll(listToAdd);
    }

    /**
     * Performs the given action for each element of the {@code LichterKette}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of LEDs.
     *
     * @implSpec
     * <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (LED led : list)
     *         action.run(led);
     * }</pre>
     */
    public void forEach(Action1<LED> action)
    {
        for (LED led : list)
        {
            action.run(led);
        }
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
        ArrayList<LED> tmp = new ArrayList<>();

        for (int i = 0; i < list.size() && i < newSize; i++)
        {
            tmp.add(list.get(i));
        }

        for (int i = list.size(); i < newSize; i++)
        {
            tmp.add(new LED());
        }

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
     * @param index Index of the LED that should be changed in Color
     * @param rgb Color the LED should be set to
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
     * @param rgb Color that the LEDs should be set to
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
                setRGB(position+i, rgb);
            }
            else
            {
                setRGB((position+i)-list.size(), rgb);
            }
        }
    }

    /**
     * Activates LEDs in with gaps
     * <pre>{@code Example:
     * +------------------------------------------------------------------------+
     * |  [o, o, o, o, o, o] | (1) => [o, R, o, R, o, R] | o = old & R = rgb    |
     * +------------------------------------------------------------------------+
     * }</pre>
     * @param gapSize The gapSize
     * @param rgb Color that the LEDs should be set to
     */
    public void setRGBInGaps(int gapSize, int rgb)
    {
        for(int i = gapSize; i < list.size(); i += gapSize+1)
        {
            setRGB(i, rgb);
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
     * @param rgb Color that the LEDs should be set to
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
                setRGB(i, rgb);
            }
        }
    }

    /**
     * Returns a string representation of this licterKette.  The string
     * representation consists of a list of the licterKette's elements in the
     * order they are returned by its iterator, enclosed in square brackets
     * ({@code "[]"}).  Adjacent elements are separated by the characters
     * {@code ", "} (comma and space).  Elements are converted to strings as
     * by {@link String#valueOf(Object)}.
     *
     * @return a string representation of this licterKette
     */
    public String toString()
    {
        return list.toString();
    }
}

