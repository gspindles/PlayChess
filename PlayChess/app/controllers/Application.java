package controllers;

import play.*;
import play.mvc.*;
import play.libs.*;
import models.*;
import views.html.*;
import play.Logger.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import java.util.List;
import java.util.ArrayList;

public class Application extends Controller {
    public static ChessGame chessGame;

    public static Result index() {
        if (chessGame == null) {
            chessGame = new ChessGame();
        }
        return ok(index.render("The game has started."));
    }


    public static Result getPossibleMoves(int x, int y) {
        Logger.info("x:" + x + " y: " + y);
        List<Point> ps = new ArrayList<Point>();
        ps = chessGame.getPossibleMoves(x, y);
        if (ps == null) { Logger.info("Empty list\n"); }
        for (Point p : ps) { Logger.info("Point : " + x + " " + y + "\n" ); }

        /*Point p = new Point(x, y);
        Point[] ps = new Point[8];
        ps[0] = new Point(p.x + 1, 7 - p.y - 1);
        ps[1] = new Point(p.x, 7 - p.y - 1);
        ps[2] = new Point(p.x - 1, 7 - p.y - 1);
        ps[3] = new Point(p.x + 1, 7 - p.y);
        ps[4] = new Point(p.x - 1, 7 - p.y);
        ps[5] = new Point(p.x + 1, 7 - p.y + 1);
        ps[6] = new Point(p.x, 7 - p.y + 1);
        ps[7] = new Point(p.x - 1, 7 - p.y + 1);*/
        return ok(Json.toJson(ps));
    }


    public static Result MovePiece(int fromX, int fromY, int toX, int toY) {
        /*Logger.info("from (" + fromX + ", " + fromY + ") to (" + toX + ", " + toY + ")\n");
        Point from = new Point(fromX, fromY);
        Point to = new Point(toX, toY);
        boolean result = chessGame.MovePiece(from, to);
        return ok(result);*/


        return ok("true");
    }


    public static Result aiMakeSeqMove() {
        /*Logger.info("AI is going to make a move");
        List<Point> fromto = chessGame.aiMakeATurnSequential();
        return ok(Json.toJson(fromto));*/

        return ok();
    }


    public static Result aiMakeParMove() {
        /*Logger.info("AI is going to make a move");
        List<Point> fromto = chessGame.aiMakeATurnParallel();
        return ok(Json.toJson(fromto));*/

        return ok();
    }
}
