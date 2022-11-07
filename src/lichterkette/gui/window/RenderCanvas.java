package lichterkette.gui.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class RenderCanvas extends Canvas
{   
    private BufferedImage buffer;

    private BufferStrategy bufferStrategy;

    @Override
    public void setSize(int width, int height) 
    {
        super.setSize(width, height);
    
        buffer = createCompatibleBufferedImage(width, height);
    }

    public void render(RenderAction action)
    {
        if (bufferStrategy == null)
        {        
            createBufferStrategy(2);
            
            bufferStrategy = getBufferStrategy();
        }
    
        Graphics2D bufferGraphics = buffer.createGraphics();

        bufferGraphics.setColor(Color.white);
        bufferGraphics.fillRect(0, 0, getWidth(), getHeight());

        action.render(bufferGraphics, getWidth(), getHeight());

        bufferGraphics.dispose();

        do 
        {
            do 
            {
                Graphics graphics = bufferStrategy.getDrawGraphics();

                //RENDER START

                    graphics.drawImage(buffer, 0, 0, null);

                //RENDER END

                graphics.dispose();
    
            } while (bufferStrategy.contentsRestored());
    
            bufferStrategy.show();

        } while (bufferStrategy.contentsLost());
    }   
    
    private final static GraphicsConfiguration gfx_config;

    static {
        gfx_config = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getDefaultScreenDevice()
            .getDefaultConfiguration();
    }
    
    private static BufferedImage createCompatibleBufferedImage(int width, int height)
    {
        return gfx_config.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    }
}
