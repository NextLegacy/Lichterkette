package app.scenes;

import app.scripts.ImageButton;
import engine.GameObject;
import engine.Scene;
import engine.Script;
import engine.utils.graphics.Image;

import static engine.utils.MathUtils.*;

import java.awt.Font;

public class StartScene extends Scene
{
    private Image background;

    private GameObject backgroundGameObject;
    private GameObject startButton;

    @Override
    protected void init() 
    {
        background = Image.fromFile("./rsc/images/title.png");

        backgroundGameObject = new GameObject("backgroundGameObject");
        startButton = new GameObject("startButton");

        addGameObject(backgroundGameObject);
        addGameObject(startButton);

        startButton.addScript(new ImageButton(Image.fromFile("./rsc/images/start.png"), vec(16, 9).times(8), () -> 
        {
            engine().setActiveScene(new LEDScene());
        }));

        startButton.transform().position().set(window().size(0.5, 0.8));
        startButton.transform().scale().set(vec(16, 9).times(8));

        backgroundGameObject.addScript(new Script() {
            @Override
            protected void awake() {
                setActive(true);
            }
            @Override
            protected void render() {
                image().drawImage(background);
            }   
        });

        startButton.setActive(true);
        backgroundGameObject.setActive(true);
    }
}
