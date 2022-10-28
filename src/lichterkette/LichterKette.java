package lichterkette;

import java.util.ArrayList;

public class LichterKette 
{
    ArrayList<LED> lichterkette;

    public LichterKette()
    {
        lichterkette= new ArrayList<>();
    }

    public void leuchten(int n)
    {
        for(int i=n; i < lichterkette.size(); i+=n)
        {
            LED led = lichterkette.get(i);
            led.setLeuchtet(true);
        }
    }  
}
