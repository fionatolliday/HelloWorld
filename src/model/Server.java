package model;

import com.sun.net.httpserver.HttpServer;
import handlers.GreetingHandler;
import handlers.PersonHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    private World world;
    HttpServer server;

    public Server (World world) { this.world = world;
    }

    public void runServer(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/greeting", new GreetingHandler(world));
        server.createContext("/names", new PersonHandler(world));
        server.setExecutor(null); // creates a default executor. this submits a new task
        server.start();
    }

    public void stopServer() {
        server.stop(0);
    }
}
