package app.scripts;

import engine.Script;
import engine.math.Vector;
import engine.math.Vector4;
import engine.utils.Lambda.Action1;
import engine.utils.Lambda.Action2;
import lichterkette.LED;
import lichterkette.LichterKette;
import lichterkette.LichterKette2D;

import static engine.utils.MathUtils.*;

import app.App;

public class LichterKettenScript extends Script 
{
    private LichterKette2D lichterKette;

    public Vector ledSize;
    public Vector size;

    public LichterKettenScript(Vector4 size)
    {
        this.size = size.toVector();
    }
    
    @Override
    protected void awake() {
        setActive(true);
    }

    @Override
    protected void start() 
    {
        setSize(size);
    }

    public void setSize(Vector4 size)
    {
        this.size = size.toVector();
        ledSize = window().size().dividedBy(size);
    
        if (lichterKette == null)
            lichterKette = new LichterKette2D(0);
        lichterKette.setSize(size.int_x(), size.int_y());
    }

    @Override
    protected void update() 
    {
        ((Action2<LichterKettenScript, LichterKette2D>)App::update).run(this, lichterKette);
    }

    @Override
    protected void render() 
    {
        for (int x = 0; x < size.int_x(); x++)
        {
            for (int y = 0; y < size.int_y(); y++)
            {
                LED led = lichterKette.getLichterkette(x).get(y);
                
                if (!led.getActive()) continue;

                image().rect(ledSize.times(vec(x, y)), ledSize.times(vec(x, y).plus(1)), 1, (a, b, z) -> led.getRgb() + 0xff000000);
            }
        }
    }
}
