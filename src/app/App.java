package app;

import engine.Engine;
import engine.math.Vector;
import engine.utils.graphics.Image;
import lichterkette.LichterKette2D;

import static engine.utils.MathUtils.*;

import java.awt.event.KeyEvent;

import app.scenes.StartScene;
import app.scripts.LichterKettenScript;

public class App 
{
    private App() { }

    public static Engine engine;

    public static void main(String[] args)
    {
        engine = new Engine(vec(1080, 720), 60, 60, "main");

        engine.setActiveScene(new StartScene());

        engine.activate();
    }

    public static void update(LichterKettenScript script, LichterKette2D lichterKetten)
    {
        Image image = Image.fromFile("./rsc/images/start.png").scaled(script.size);

        for (int x = 0; x < lichterKetten.getSize(); x++)
        {
            for (int y = 0; y < lichterKetten.getLichterkette(x).getSize(); y++)
            {
                lichterKetten.getLichterkette(x).get(y).setActive(true);
                lichterKetten.getLichterkette(x).get(y).setRGB(image.colorBuffer()[image.getIndex(x, y)]);
            }   
        
            lichterKetten.getLichterkette(x).setActiveInGaps(1, false);
        }

        script.setSize(script.size.plus(engine.input().wheel().direction()));
    }
}
