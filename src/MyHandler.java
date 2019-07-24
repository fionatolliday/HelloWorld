import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

//class MyHandler implements HttpHandler {
//    @Override
//    public void handle(HttpExchange t) throws IOException {
//        World world = new World(new Person("Fiona"));
//
//        String response = world.greet(world.listOfNames(world.people));
//        t.sendResponseHeaders(200, response.length());
//        OutputStream os = t.getResponseBody();
//        os.write(response.getBytes());
//        os.close();
//    }
//
//}
