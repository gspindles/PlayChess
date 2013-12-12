/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author the0ldknighte
 */
public class ChessJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        System.out.println("test");
        List<Point> list = new ArrayList<Point>();
        ChessGame game = new ChessGame();        
        game.MovePiece(4, 1, 4, 3);
        game.MovePiece(3, 6, 3, 4);
        game.MovePiece(5, 0,1 ,4 );
        game.MovePiece(3, 1, 3, 2);
        Move temp = null;
        System.out.println(game.getBoard().getKing(Side.BLACK).toString() + "\n");
        try
        {
            temp = game.aiMakeATurnSequential(Side.BLACK);
            System.out.println(temp.getTime());
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        List<Point> t = game.getPossibleMoves(3, 0);
        for(int i = 0; i < t.size(); i ++)
        {
            System.out.println(t.get(i).toString());
        }
        
        System.out.println(temp.toString());
//        list = game.getPossibleMoves(0, 1);
//        for(int i = 0; i < list.size(); i++)
//        {
//            System.out.println(list.get(i).toString());
//        }
        //Move actualMove = ai.actualMove(Side.WHITE, game.getBoard());
        //System.out.println(actualMove.toString());
        //game.getPossibleMoves(1, 1);
        System.out.println("test again");
    }
}
