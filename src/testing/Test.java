package testing;

import engine.Engine;

import static engine.utils.MathUtils.*;

import app.scenes.StartScene;

public class Test 
{
    private Test() { }

    public static void main(String[] args)
    {
        testGUI();
    }

    public static void testGUI()
    {
        Engine engine = new Engine(vec(1080, 720), 60, 60, "main");

        engine.setActiveScene(new StartScene());

        engine.activate();
    }
}
