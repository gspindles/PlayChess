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
        AI ai = new AI();
        list = game.getPossibleMoves(0, 1);
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).toString());
        }
        //Move actualMove = ai.actualMove(Side.WHITE, game.getBoard());
        //System.out.println(actualMove.toString());
        //game.getPossibleMoves(1, 1);
        System.out.println("test again");
    }
}
