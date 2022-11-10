package lichterkette;

/**
 * LichterKette extended to 2D, used to simulate a grid of LEDs
 * 
 * @author XrossXross
 * @author Verodox
 * @author bbddvv
 * @author NextLegcy 
 */
public class LED 
{
    //TODO: make documentation here

    public static final int DEFAULT_COLOR = 0x000000;

    private boolean active; // Active could be equivalent to 0x000000

    /** 
     * <pre>rgb is a number between 0x000000 and 0xffffff</pre>
     * <pre>usage: {@code rgb = 0xff0000; //red color}</pre>
     */
    private int rgb;
    
    public LED() { this(false, DEFAULT_COLOR); }
    
    public LED(boolean active, int rgb)
    {
        setActive(active);
        setRGB(rgb);
    }

    public boolean getActive() { return active; }
    public int getRgb() { return rgb; }

    public void setActive(boolean state) { active = state; }
    public void setRGB(int rgb) { this.rgb = rgb; }
}
