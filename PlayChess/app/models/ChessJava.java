/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
        ChessGame game = new ChessGame();
        AI ai = new AI();
        Move actualMove = ai.actualMove(Side.BLACK, game.getBoard());
        System.out.println(actualMove.toString());
        //game.getPossibleMoves(1, 1);
        System.out.println("test again");
    }
}
