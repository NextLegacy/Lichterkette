package testing;

import lichterkette.gui.GUI;

public class Test 
{
    private Test() { }

    public static void main(String[] args)
    {
        testGUI();
    }

    public static void testGUI()
    {
        GUI gui = new GUI();

        while(true)
            gui.renderGUIContent();
    }
}
