package app.scripts;

import engine.Script;
import engine.utils.Lambda.Action0;

import static engine.utils.MathUtils.*;

public class UIButton extends Script
{
    private final Action0 onClick;
    
    protected boolean isHovering;

    public UIButton(Action0 onClick)
    {
        this.onClick = onClick;
    }   

    @Override
    protected void awake() 
    {
        setActive(true);
    }

    @Override
    protected void update() 
    {
        isHovering = mouse().isInBounds(position().plus(vec(0, scale().y()/2)), scale());
        
        if (isHovering && left().isClicked())
            onClick.run();
    }
}
