package lichterkette;

import java.util.ArrayList;

public class LichterKette2D
{
    private ArrayList<LichterKette> liste;
    
    public LichterKette2D(int Size)
    {

    } 
    /**
     * The list Element at "Index" will get returned
     * @param index
     * @return
     */
    public LichterKette getLichterkette(int index)
    {
        return liste.get(index); 
    }
    /**
     * The size of the List will be returned
     * @return
     */
    public int getSize()
    {
        return liste.size();
    }
    /**
     * The current list will be resized to the given parameter "size"
     * 
     * Current list:
     * [1,0,1,0,1]
     * 
     * setSize(3);
     * 
     * after that:
     * [1,0,1]
     * 
     * if size > liste.size();
     * 
     * Current list:
     * [1,0,1,0,1]
     * 
     * setSize(8);
     * 
     * after that:
     * [1,0,1,0,1,0,0,0]
     * 
     * @param size
     */
    public void setSize(int size)
    {
        ArrayList<LichterKette> tmp = new ArrayList<LichterKette>(size);

        for(int i = 0; i< liste.size() && i < size; i ++)
        {
            tmp.set(i, liste.get(i));
        }
        for(int i = liste.size(); i < size; i++)
        {
            tmp.set(i, new LichterKette());
        }
        liste = tmp;
    }
    /**
     * The list at the given index "index" will be overwritten by the given Lichterkette "laufkette"
     * @param laufkette
     * @param index
     */
    public void setLichterKette(LichterKette laufkette, int index)
    {
        liste.set(index, laufkette);
    }


   
}