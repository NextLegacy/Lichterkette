package lichterkette;

import java.util.ArrayList;
import java.util.Collection;

import engine.utils.Lambda.Action1;

/**
 * LichterKette extended to 2D, used to simulate a grid of LEDs
 * 
 * @author XrossXross
 * @author Verodox
 * @author bbddvv
 * @author NextLegcy 
 */
public class LichterKette2D
{
    private ArrayList<LichterKette> list;
    
    public LichterKette2D(int size)
    {
        list = new ArrayList<>();
        setSize(size);
    } 

    /**
     * Appends the specified elements to the end of this list.
     *
     * @param e elements to be appended to this list
     */
    public void add(LichterKette... lichterKetten)
    {
        for (LichterKette led : lichterKetten)
            if (led != null)
                list.add(led);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the
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
    public boolean addAll(Collection<LichterKette> collection)
    {
        return list.addAll(collection);
    }

    /**
     * Performs the given action for each element of the {@code LichterKette2D}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of lichterKetten.
     *
     * @implSpec
     * <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (LichterKette lichterKette : list)
     *         action.run(lichterKette);
     * }</pre>
     */
    public void forEach(Action1<LichterKette> action)
    {
        for (LichterKette lichterKette : list)
        {
            action.run(lichterKette);
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public LichterKette getLichterkette(int index)
    {
        return list.get(index); 
    }

    /**
     * Returns the number of LichterKette's in this LichterKette2D
     * @return the number of LichterKette's in this LichterKette2D
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
        ArrayList<LichterKette> tmp = new ArrayList<>();

        for (int i = 0; i < list.size() && i < newSize; i++)
        {
            tmp.add(list.get(i));
        }

        for (int i = list.size(); i < newSize; i++)
        {
            tmp.add(new LichterKette());
        }

        list = tmp;
    }

    /**
     * Set size for all elements
     * @param sizeForAll size to set elements to
     */
    public void setSizeforAll(int sizeForAll)
    {
        for(int i = 0; i < list.size(); i++ )
        {
            getLichterkette(i).setSize(sizeForAll);
        }
    }
    
    /**
     * Set size to {@code width} and size of elements to {@code height}
     * @param width count of lichterketten
     * @param height count of leds in lichterketten
     */
    public void setSize(int width, int height)
    {
        setSize(width);
        setSizeforAll(height);
    }

    /**
     * Replaces the lichterKette at the specified position in this lichterKette2D with the specified element.
     * @param lichterKette element to be stored at the specified position 
     * @param index index of the element to replace
     */
    public void setLichterKette(LichterKette lichterKette, int index)
    {
        list.set(index, lichterKette);
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