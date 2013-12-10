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

public class Application extends Controller {
    public static ChessGame chessGame;

    public static Result index() {
        if (chessGame == null) {
            chessGame = new ChessGame();
        }
        return ok(index.render("The game has started."));
    }


    public static Result getPossibleMoves(int x, int y) {
        List<Point> ps = chessGame.getPossibleMoves(x, y);
        return ok(Json.toJson(ps));
    }
}
