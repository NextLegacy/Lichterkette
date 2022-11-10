package app.scripts;

import engine.math.Vector;
import engine.math.Vector4;
import engine.utils.Lambda.Action0;
import lichterkette.LED;

public class LEDButton extends UIButton
{
    private LED led;
    
    public LEDButton(Action0 onClick)
    {
        super(onClick);
    }   

    public void setLED(LED led)
    {
        this.led = led;
    }

    public void setPosition(Vector4 position)
    {
        position().set(position);
    }

    public void setSize(Vector4 size)
    {
        scale().set(size);
    }

    @Override
    protected void awake() 
    {
        setActive(true);
    }

    double t;

    @Override
    protected void update() 
    {

    }

    @Override
    protected void render() 
    {
        if (image().isNot("main")) return;
        if (led == null) return;

        image().rect(position().times(scale()), position().times(scale()).plus(scale()), 1, (x, y, z) -> 0xff00ff00);
    } 
}
