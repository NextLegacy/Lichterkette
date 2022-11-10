package lichterkette.gui;

import engine.GameObject;
import engine.Scene;
import engine.Script;
import engine.math.Vector;
import engine.utils.graphics.Image;

public class LEDScene extends Scene 
{
    @Override
    protected void init() 
    {
        GameObject gameObject = new GameObject();

        addGameObject(gameObject);
        gameObject.addScript(new Script() 
        { 
            @Override
           protected void awake() {
               setActive(true);
           } 

           @Override
               protected void render() {
                   image().drawImage(Image.fromFile("./rsc/menu.png"));
               }
        });
        gameObject.setActive(true);
    }    
}
