package web.server;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class WebServer {

    public static void main(String[] args){

        System.setProperty("com.spark.shaded.eclipse.jetty.LEVEL","OFF");

        port(8080);

        get("/posttest", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                String name = request.queryParams("name");
                String colour = request.queryParams("favorite");

                String returnHtml = "<html><body><p style=\"color:"+ colour + ";\">Hello, " + name + "</p></body></html>";
                return returnHtml;
            }

        });

        notFound("404 Not Found");

    }
}
