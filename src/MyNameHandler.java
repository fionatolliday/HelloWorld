import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

class MyNameHandler implements HttpHandler {

    private World world;

    public MyNameHandler(World world) {
        this.world = world;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = world.getNamesOfPeople().toString();
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}

