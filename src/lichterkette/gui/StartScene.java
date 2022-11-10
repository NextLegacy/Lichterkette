package lichterkette.gui;

import engine.GameObject;
import engine.Scene;
import engine.Script;
import engine.math.Vector;
import engine.utils.graphics.Image;

import static engine.utils.MathUtils.*;

public class StartScene extends Scene
{
    @Override
    protected void init() 
    {
        GameObject gameObject = new GameObject();

        addGameObject(gameObject);
        
        gameObject.addScript(new Button(() -> 
        {
            engine().setActiveScene(new LEDScene());
        }));

        gameObject.addScript(new Script() { 
            //Just Testing, and its works niceeeeeee, did not think that it will
            //. Its 00:58 I should probably go to sleep
           @Override
           protected void awake() {
               setActive(true);
           } 

           @Override
               protected void render() {
                   image().drawImage(Image.fromFile("./rsc/title.png"));
               }
        });

        gameObject.setActive(true);

        gameObject.transform().position().set(window().size(0.5, 0.75));
        gameObject.transform().scale().set(vec(18, 9).times(5));
    }
}
