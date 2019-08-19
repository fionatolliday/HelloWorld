import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class GreetingHandler implements HttpHandler {
    private World world;

    public GreetingHandler(World world) {
        this.world = world;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = world.greet();
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}