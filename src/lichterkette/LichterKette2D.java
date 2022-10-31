package lichterkette;

import java.util.ArrayList;

public class LichterKette2D
{
    private ArrayList<LichterKette> liste;
    
    public LichterKette2D(int Size)
    {

    } 
    public LichterKette getLichterkette(int index)
    {
        return liste.get(index);
    }
    public int getSize()
    {
        return liste.size();
    }
    public void setSize(int size)
    {
        ArrayList<LichterKette> tmp = new ArrayList<LichterKette>(size);

        for(int i = 0; i< liste.size() && i < size; i ++)
        {
            tmp.set(i, liste.get(i));
        }
        for(int i = liste.size(); i < size; i++)
        {
            tmp.set(i, new LED())
        }
        list = tmp;
    }


   
}