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
        return ok(Json.toJson(ps));
    }


    public static Result MovePiece(int fromX, int fromY, int toX, int toY) {
        Logger.info("from (" + fromX + ", " + fromY + ") to (" + toX + ", " + toY + ")\n");
        boolean result = chessGame.MovePiece(fromX, fromY, toX, toY);
        if (result) { return ok("true"); }
        return ok("false");
    }


    public static Result aiMakeSeqMove() {
        Logger.info("AI is going to make a move");
        Move aiSeq = chessGame.aiMakeATurnSequential(Side.BLACK);
        return ok(Json.toJson(aiSeq));
    }


    public static Result aiMakeParMove() {
        Logger.info("AI is going to make a move");
        Move aiPar = chessGame.aiMakeATurnParallel(Side.BLACK);
        return ok(Json.toJson(aiPar));
    }


    public static Result getBoard() {
        return ok(Json.toJson(chessGame));
    }
}
