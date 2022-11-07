package lichterkette.gui.window;

import java.awt.Graphics2D;

@FunctionalInterface 
public interface RenderAction 
{
    void render(Graphics2D graphics, int width, int height);
}