package app.scenes;

import app.scripts.LichterKettenScript;
import engine.GameObject;
import engine.Scene;
import engine.math.Vector;

public class LEDScene extends Scene 
{
    private GameObject resetButton;
    private GameObject lichterKetten;

    @Override
    protected void init() {
        lichterKetten = new GameObject();
    
        addGameObject(lichterKetten);

        lichterKetten.addScript(new LichterKettenScript(new Vector(20, 20)));
        
        lichterKetten.setActive(true);
    }
}
