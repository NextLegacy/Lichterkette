package lichterkette;

import java.util.ArrayList;

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
    
    public LichterKette2D(int Size)
    {
        //TODO: Timon initsalisiere die liste gefälligst
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
        ArrayList<LichterKette> tmp = new ArrayList<LichterKette>(newSize);

        for(int i = 0; i< list.size() && i < newSize; i ++)
            tmp.set(i, list.get(i));
            
        for(int i = list.size(); i < newSize; i++)
            tmp.set(i, new LichterKette());

        list = tmp;
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
}