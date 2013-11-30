/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessjava;

/**
 *
 * @author the0ldknighte
 */
public class Move 
{
    private Point start;
    private Point end;    
    private ChessPiece piece;
    
    private ChessPiece takenPiece = null;
    private boolean check = false;
    
    /* chessPiece p is the piece that is moving
     *  Point s is starting point point e is ending point
     */
    public Move(Point s, Point e,ChessPiece p)
    {        
        if(s.x >= 0 & s.x <= 7)
        {
            start.x = s.x;
        }
        if(s.y >= 0 & s.y <= 7)
        {
            start.y = s.y;
        }
        if(e.x >= 0 & e.x <= 7)
        {
            end.x = e.x;
        }
        if(e.y >= 0 & e.y <= 7)
        {
             end.y = e.y;
        }
        piece = p;        
    }
    
    /* chessPiece p is the piece that is moving
     *  Point s is starting point point e is ending point
     * boolean check the king is in check
     */
    public Move(Point s, Point e,ChessPiece p, boolean check)
    {        
        if(s.x >= 0 & s.x <= 7)
        {
            start.x = s.x;
        }
        if(s.y >= 0 & s.y <= 7)
        {
            start.y = s.y;
        }
        if(e.x >= 0 & e.x <= 7)
        {
            end.x = e.x;
        }
        if(e.y >= 0 & e.y <= 7)
        {
             end.y = e.y;
        }
        piece = p;
        check = true;
    }
    /* chessPiece p is the piece that is moving
     * chessPiece t is the taken piece
     *  Point s is starting point point e is ending point
     */
    public Move(Point s, Point e,ChessPiece p,ChessPiece t)
    {
        if(s.x >= 0 & s.x <= 7)
        {
            start.x = s.x;
        }
        if(s.y >= 0 & s.y <= 7)
        {
            start.y = s.y;
        }
        if(e.x >= 0 & e.x <= 7)
        {
            end.x = e.x;
        }
        if(e.y >= 0 & e.y <= 7)
        {
             end.y = e.y;
        }
        piece = p;
        takenPiece = t;
    }
    public Point getStart()
    {
        return start;
    }
    public void setStart(Point s)
    {
        if(s.x >= 0 & s.x <= 7)
        {
            if(s.y >= 0 & s.y <= 7)
            {
                start = s;
            }
        }
    }
    public Point getEnd()
    {
        return end;
    }
    public void setEnd(Point e)
    {
        if(e.x >= 0 & e.x <= 7)
        {
            if(e.y >= 0 & e.y <= 7)
            {
                end = e;
            }
        }
    }    
    public ChessPiece getPiece()
    {
        return piece;
    }
    public void setPiece(ChessPiece p)
    {
        piece = p;
    }
    public ChessPiece getTakenPiece()
    {
        return takenPiece;
    }
    public void setTakenPiece(ChessPiece p)
    {
        takenPiece = p;
    }    
}
