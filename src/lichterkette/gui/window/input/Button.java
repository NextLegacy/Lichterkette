package lichterkette.gui.window.input;

public class Button
{
    private boolean isDown;
    private double timeOnStart;
    private boolean clicked;
    private boolean clickedHelp;

    Button()
    {
        isDown = false;
        timeOnStart = 0.0d;
    }

    void press() 
    {
        isDown = true;
        clickedHelp = true;
        timeOnStart = System.nanoTime();
    }

    void release() 
    {
        isDown = false;
    }

    void update() 
    {
        if (!clickedHelp) return;
        if (!isUp()) return;

        if (clicked)
        {
            clicked = clickedHelp = false;
            return;
        }

        clicked = true;
    }

    public boolean isDown     () { return isDown;                                              }
    public boolean isUp       () { return !isDown();                                           }
    public boolean isClicked  () { return clicked;                                             }
    public double  downTime   () { return isDown ? System.nanoTime() - timeOnStart : 0;        }
    public double  timeOnStart() { return timeOnStart;                                         }
}