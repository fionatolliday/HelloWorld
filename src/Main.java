import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import handlers.GreetingHandler;
import handlers.PersonHandler;
import interfaces.DateTimeInterface;
import model.DateTime;
import model.World;
import storage.LocalPersonStorage;


public class Main {

    public static void main(String[] args) throws IOException {

    World world = new World(new LocalPersonStorage(), new DateTime());

         HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/greeting", new GreetingHandler(world));
            server.createContext("/names", new PersonHandler(world));
            server.setExecutor(null); // creates a default executor. this submits a new task
            server.start();
        }

}
