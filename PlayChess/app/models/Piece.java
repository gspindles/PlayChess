/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.awt.Point;

/**
 *
 * @author the0ldknighte
 */
public class Piece 
{
    protected Point location = null;
    protected int imageID = 0;
    protected int team = 0;
    public Piece()
    {                 
      
    }
    public Piece(Point p, int img, int tm)
    {
         location = p;
         imageID = img;
         team = tm;
    }
    public void move()
    {
        
    }    
    public Point getLocation()
    {
        return location;
    }
    public void setLocation(Point p)
    {
        if(p.x > 1 & p.y > 1)
        {
            if(p.x <= 8 & p.y <= 8)
            {
                location = p;
            }
        }
        System.out.println("the input point was out of bounds");       
    }   
    
}
