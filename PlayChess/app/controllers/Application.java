package controllers;

import play.*;
import play.mvc.*;
import play.libs.*;
import chessjava.*;
import views.html.*;
import play.Logger.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class Application extends Controller {

    public static Result index() {
    	ChessGame chessGame = new ChessGame();
        return ok(index.render("Your new application is ready."));
    }

    public static Result getPossibleMoves(int x, int y) {
        // temporary toy for now
        Logger.info("x:" + x + " y: " + y);
        Point p = new Point(x, y);
        Point[] ps = new Point[3];
        ps[0] = new Point(p.x, p.y - 1);
        ps[1] = new Point(p.x + 1, p.y - 1);
        ps[2] = new Point(p.x - 1, p.y - 1);
    	return ok(Json.toJson(ps));
    }
}
