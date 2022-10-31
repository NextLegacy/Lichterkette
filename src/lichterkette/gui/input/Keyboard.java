package lichterkette.gui.input;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/** Code from https://github.com/NextLegacy/Engine/tree/master/src/engine/window/Input */
public final class Keyboard
{
    private final HashMap<Integer, Key> KEY_MAP;

    Keyboard()
    {
        KEY_MAP = new HashMap<>();

        initializeKeyMap();
    }

    public Key get(Integer keyEvent)
    {
        return !KEY_MAP.containsKey(keyEvent) ? Key.NULL_KEY : KEY_MAP.get(keyEvent);
    }

    //Super Lazy but easy initializing 
    //TODO: Make a initializing Method that does not use reflection
    private void initializeKeyMap()
    {
        Field[] fields = KeyEvent.class.getDeclaredFields();
    
        for (Field field : fields) 
        {
            if (Modifier.isPrivate(field.getModifiers()) || !Modifier.isStatic(field.getModifiers())) 
                continue;

            try
            {
                if (field.get(null) instanceof Integer event)
                { 
                    KEY_MAP.put(event, new Key(event));
                }
            } 
            catch (IllegalArgumentException | IllegalAccessException e) 
            {
                e.printStackTrace();
            }
        }   
    }
}