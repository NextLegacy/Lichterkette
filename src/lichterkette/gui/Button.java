package lichterkette.gui;

import engine.Script;
import engine.math.Vector;
import engine.utils.Lambda.Action0;

import static engine.utils.MathUtils.*;

public class Button extends Script
{
    private final Action0 onClick;

    private Vector size;

    public Button(Action0 onClick)
    {
        this.onClick = onClick;
        size = vec();
    }   

    @Override
    protected void awake() 
    {
        System.out.println("awake");
        setActive(true);
    }

    double t;
    @Override
    protected void update() 
    {
        if (mouse().isInBounds(position(), size))
        {
            t += deltaTime();

            size = Vector.lerp(scale(), scale().times(1.25), t * 18);

            if (left().isClicked())
                onClick.run();
        }
        else 
        {
            t = 0;
            size = scale();
        }
    }

    @Override
    protected void render() 
    {
        //System.out.println("render");
        if (image().isNot("main")) return;

        image().rect(position().minus(size.divideBy(2)), position().plus(size.divideBy(2)), 1, (x, y, z) -> 0xff00ff00);
    } 
}
