package lichterkette.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import lichterkette.gui.window.RenderCanvas;
import lichterkette.gui.window.Window;

public class GUI extends Window
{    
    private RenderCanvas content;

    public GUI() { super(1080, 720); }

    @Override
    public void initComponents() 
    {
        content = new RenderCanvas();

        getInput().bindToComponent(content);

        content.setLocation((int) (getWidth() * 0), (int) (getHeight() * 0.075));
        content.setSize    ((int) (getWidth() * 1), (int) (getHeight() * 0.925) - getVerticalInsets());

        addComponent(content);

        content.setVisible(true);
    }

    public void renderGUIContent()
    {
        content.render(this::render);
    }

    private void render(Graphics2D graphics, int width, int height)
    {
        graphics.setColor(Color.black);

        int x = getInput().mouse().position().int_x();
        int y = getInput().mouse().position().int_y();

        graphics.fillRect(x, y, width, height);
    }
}