package lichterkette.gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import lichterkette.LED;

public class GUI extends JFrame
{
    public GUI()
    {
        
    }

    public ArrayList<LED> list;

    public void setSize(int size)
    {
        ArrayList<LED> resizedList = new ArrayList<>(size);

        for (int i = 0; i < list.size() && i < size; i++) 
            resizedList.set(i, list.get(i));

        for (int i = list.size(); i < size; i++)
            resizedList.set(i, new LED());
    
        list = resizedList;
    }
}
