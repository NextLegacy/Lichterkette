package app.scripts;

import engine.Script;
import engine.math.Vector;
import engine.math.Vector4;
import engine.utils.Lambda.Action0;
import engine.utils.graphics.Image;

import static engine.utils.MathUtils.*;

public class ImageButton extends UIButton
{
    private final Image image;
    private Image imageScaled;

    protected Vector size;
    
    public ImageButton(Image image, Vector4 size, Action0 onClick)
    {
        super(onClick);
        this.image = image;
        this.size = size.toVector();
        imageScaled = this.image;
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
        super.update();

        if (isHovering)
        {
            t += deltaTime();

            scale().set(Vector.lerp(size, size.times(1.25), t * 18));
        }
        else 
        {
            t = 0;

            scale().set(size);
        }

        imageScaled = image.scaled(scale());
    }

    @Override
    protected void render() 
    {
        if (image().isNot("main")) return;

        Vector4 pos = position().minus(scale().dividedBy(2));

        image().drawImage(imageScaled, pos.int_x(), pos.int_y());

        //image().rect(, 1, (x, y, z) -> 0xff00ff00);
    } 
}
