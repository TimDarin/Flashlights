package flashlights;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;

public class GUI extends JApplet implements MouseListener, MouseMotionListener
{	
    /**
     * Initialize the applet.  Create the shapes, and
     * register this object as a listener to mouse events
     * produced by this object.
     */
    public void init ()
    {
        // Register this object as a listener to its own events.
        this.addMouseListener (this);
        this.addMouseMotionListener (this);
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        float newTLCX = dimension.width * 0.5f;
        float newTLCY = dimension.height * 0.5f;
        float newWidth = dimension.width * 0.5f;
        float newHeight = dimension.height * 0.5f;
        
        this.resize((int)newWidth, (int)newWidth);
        this.setLocation((int)newTLCX, (int)newTLCY);
    }

    public void paint (Graphics g)
    {
        // Create an off-screen buffer.
        Image offscreenBuffer = createImage(this.getWidth(), this.getHeight());
        Graphics offscreenGraphics = offscreenBuffer.getGraphics();

        // Fill it with a nice color.
        offscreenGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());

        // Draw the offscreen buffer to the screen.
        g.drawImage(offscreenBuffer, 0, 0, this);

        // TODO Note - a better but more complicated way to do double buffering
        // TODO is to use BufferStrategy objects.
    }

    /**
     * This method is part of the MouseListener interface.
     * Because we registered this applet object as a listener
     * to its own mouse events, this method will be automatically
     * called whenever the mouse button is pressed down.
     * <p>
     * @param e
     *         the mouse event
     */
    public void mouseClicked  (MouseEvent e) 
    {
        // Get the location of the mouse click within this window.
        int x = e.getX (); 
        int y = e.getY ();
    }
    
    // Unused event methods (required by the interfaces).
    public void mouseReleased (MouseEvent e) { }
    public void mouseDragged  (MouseEvent e) { }
    public void mousePressed  (MouseEvent e) { }
    public void mouseEntered  (MouseEvent e) { }
    public void mouseExited   (MouseEvent e) { }
    public void mouseMoved    (MouseEvent e) { }
}
