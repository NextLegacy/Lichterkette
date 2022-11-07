package lichterkette.gui.window;

import java.awt.Component;

import javax.swing.JFrame;

import lichterkette.gui.window.input.Input;

public abstract class Window
{
    private JFrame frame;

    private Input input;

    private final int width;
    private final int height;

    public Window(int width, int height)
    {
        this.width  = width;
        this.height = height;

        initFrame();
    }

    private void initFrame()
    {
        frame = new JFrame();

        input = new Input();
        //    .bindToFrame(frame);

        //frame.setUndecorated(true);

        frame.setResizable(false);
        
        //frame.setIgnoreRepaint(true);
        frame.setFocusable(true);
        frame.requestFocus();

        frame.setLayout(null);

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        initComponents();
    }

    public abstract void initComponents();

    public void addComponent(Component component)
    {
        frame.add(component);
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public Input getInput()
    {
        return input;
    }

    public void setTitle(String title)
    {
        frame.setTitle(title);
    }
    
    public String getTitle()
    {
        return frame.getTitle();
    }

    public int getWidth() 
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getVerticalInsets()
    {
        return frame.getInsets().top + frame.getInsets().bottom;
    }
}
