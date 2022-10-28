package lichterkette;

import java.util.ArrayList;

public class LichterKette 
{
    ArrayList<Object> lichterkette;

    public void leuchten(int n)
    {
        for(int i=n; i < lichterkette.size(); i+=n)
        {
            Object led = lichterkette.get(i);
            //led.leuchte();
        
        }
    }  
}
