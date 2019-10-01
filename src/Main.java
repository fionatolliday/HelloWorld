import java.io.IOException;

import model.DateTime;
import model.Server;
import model.World;
import storage.LocalPersonStorage;


public class Main {

    public static void main(String[] args) throws IOException {

        World world = new World(new LocalPersonStorage(), new DateTime());
        Server server = new Server(world);

        server.runServer(3000);

    }

}
