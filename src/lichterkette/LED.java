package lichterkette;

public class LED {
    private boolean leuchtet;
    private int RGB;
    public LED()
    {

    }
    public boolean isLeuchtet() {
        return leuchtet;
    }

    public void setLeuchtet(boolean leuchtet) {
        this.leuchtet = leuchtet;
    }
    public void setFarbe(int pRGB)
    {
        this.RGB = pRGB;
    }
    public int getFarbe()
    {
        return RGB;
    }
}
