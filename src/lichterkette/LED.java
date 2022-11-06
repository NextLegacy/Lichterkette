package lichterkette;

public class LED 
{
    public static final int DEFAULT_COLOR = 0x000000;

    private static boolean active; // Active could be equivalent to 0x000000
    private int rgb;
    
    public LED() { this(false, DEFAULT_COLOR); }
    
    public LED(boolean active, int rgb)
    {
        setActive(active);
        setRGB(rgb);
    }

    public boolean getActive() { return active; }
    public int getRgb() { return rgb; }

    public static void setActive(boolean state) { active = state; }
    public void setRGB(int rgb) { this.rgb = rgb; }
}
