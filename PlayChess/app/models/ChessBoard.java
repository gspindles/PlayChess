/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessjava;


/**
 *
 * @author the0ldknighte
 */
 public class ChessBoard 
{
    public static Piece[][] board = new Piece[7][7];
    
    public void setPiece(Point pt, Piece pc)
    {
        
    }
    public Piece getPiece(Point pt)
    {        
        if (pt.x > 0 & pt.y > 0)
        {            
            if(pt.x <= 8 & pt.y <= 8)
            {
                return board[pt.x][pt.y];
            }
        }
        return null;
    }
}
