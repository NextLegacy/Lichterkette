package lichterkette;

/**
 * LED, which can be activated and can have a color.
 * 
 * @author XrossXross
 * @author Verodox
 * @author bbddvv
 * @author NextLegcy 
 */
public class LED 
{
    /** Default Color for LEDs at the start */
    public static final int DEFAULT_COLOR = 0x000000;

    /** active */
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

    /** 
     * Returns the current state of the LED.
     * @return if the LED is active, returns true.
     */
    public boolean getActive() { return active; }
    /**
     * Returns the color in rgb of the LED.
     * @return color of LED
     */
    public int getRgb() { return rgb; }

    /**
     * Sets state of LED to {@code state}
     * @param state new State of LED
     */
    public void setActive(boolean state) { active = state; }
    
    /**
     * Sets color of LED
     * @param rgb new rgb color of led
     */
    public void setRGB(int rgb) { this.rgb = rgb; }

    /**
     * Return String representation of LED
     * @return String representation of LED
     */
    public String toString()
    {
        return "LED(" + rgb + " | " + active + ")";
    }
}
