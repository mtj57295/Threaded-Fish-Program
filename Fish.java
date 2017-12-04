/*
 * The Fish class allows you to create a constructor of it and make multiple 
    fish using the constructor parameters. There is a painComponent that creates
    the image of the fish. The run method will make the fish swim back and forth
    in the window until the user exits window.
 */
package project.pkg5.thread.compsci.pkg3;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fish extends JComponent implements Runnable{
    //Attributes
    private String color;
    private int x;
    private int y;
    private int time;
    private JFrame j;
    private boolean rev = false;
    
    
    //Explicit Constructor
    public Fish(int x, int y, String color, int time, JFrame j)
    {
        this.x = x;
        this.y = y;
        this.time = time;
        this.j = j;
        this.color = color;
        
    }
    /**PaintComponent method creates the a fish y using the graphics class and 
     * also by using the draw and fillPolygon methods of the class. Depending 
     * which way the fish is swimming it will allow the fish to turn around if 
     * it hits a wall.
     * @param g is the graphic class that you use
     */
    public void paintComponent(Graphics g){  
        Graphics2D g2 = (Graphics2D)g;
        
        if(rev == true){
            int[] xCord = new int[]{x, x-25, x-50, x-100, x-50, x-25, x};
            int[] yCord = new int[]{y, y+25, y+10, y+45, y+65, y+50, y+75};
            setColor(g2);
            g2.drawPolygon(xCord, yCord, xCord.length);
            g2.fillPolygon(xCord, yCord, xCord.length); 
            
            
        }
        else{
            int[] xCord = new int[]{x, x+25, x+50, x+100, x+50, x+25, x};
            int[] yCord = new int[]{y, y+25, y+10, y+45, y+65, y+50, y+75};
            setColor(g2);
            g2.drawPolygon(xCord, yCord, xCord.length);
            g2.fillPolygon(xCord, yCord, xCord.length);  
        }      
    }
    /**SetColor method checks to see if the parameter color equals any of the
     * choices provide by the if statements and  if it does sets the color to the
     * corresponding string
     * @param g is the graphic class to set the color with method setColor
     */
    public void setColor(Graphics2D g){
        if(color.equals("yellow") || color.equals("Yellow"))
            g.setColor(Color.yellow);
        if(color.equals("red") || color.equals("Red"))
            g.setColor(Color.red);
        if(color.equals("blue") || color.equals("Blue"))
            g.setColor(Color.blue);
            
    }
    /**The run method allows the fish to move along the window by using a while
     * loop and changing the x cord every time. It also uses the sleep method 
     * from the thread class so you can have multiple fish moving at the same
     * time or at different speeds, depending on the time that the user sets it 
     * to
     */
    public void run()
    {
        try
        {
            while(j.isEnabled())
            {
                while((x+100) < j.getWidth()){
                    rev = false;
                    x += 20;
                    repaint();
                    Thread.sleep(time);
                }
            
                while((x-100)> j.getWidth()-j.getWidth()){
                    rev = true;
                    x -= 20;
                    repaint();
                    Thread.sleep(time);
                }
            }
        }
        catch(InterruptedException e)
        {
            return;
        }
    }
   
}
