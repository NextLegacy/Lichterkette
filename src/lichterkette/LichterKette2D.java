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


   
}