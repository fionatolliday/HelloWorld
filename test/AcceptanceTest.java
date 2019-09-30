import com.sun.net.httpserver.HttpServer;
import handlers.GreetingHandler;
import handlers.PersonHandler;
import model.DateTime;
import model.World;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import storage.LocalPersonStorage;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class AcceptanceTest{

    World world = new World(new LocalPersonStorage(), new DateTime());
    HttpServer server;


    @Before
    public void serverOn() throws IOException {
        server = HttpServer.create(new InetSocketAddress(5000), 0);

        server.createContext("/greeting", new GreetingHandler(world));
        server.createContext("/names", new PersonHandler(world));
        server.setExecutor(null); // creates a default executor. this submits a new task
        server.start();
    }

    @After
    public void serverClose() {
        server.stop(0);
    }


    @Test
    public void getRequestOnGreetingHandlerReturns200Status() throws IOException {
        URL url = new URL("http://localhost:5000/greeting");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        assertEquals(200, responseCode);
    }



    @Test
    public void postRequestOnNameHandlerReturns200Status() throws IOException {
        URL urlPostName = new URL("http://localhost:5000/names?name=marcelo");
        HttpURLConnection connectionPostName = (HttpURLConnection) urlPostName.openConnection();

        connectionPostName.setRequestMethod("POST");

        int responseCodePostName = connectionPostName.getResponseCode();


        assertEquals(201, responseCodePostName);
    }

    @Test
    public void postRequestOnNameHandlerReturnsMarceloAdded() throws IOException {
        URL urlPostName = new URL("http://localhost:5000/names?name=marcelo");
        HttpURLConnection connectionPostName = (HttpURLConnection) urlPostName.openConnection();

        connectionPostName.setRequestMethod("POST");

        byte[] bytes = connectionPostName.getInputStream().readAllBytes();
        String postName = new String(bytes);


        assertEquals("marcelo added", postName);
    }

    @Test
    public void deleteRequestOnNameHandlerReturnsOKMarceloDeleted() throws IOException {
        URL urlPostName = new URL("http://localhost:5000/names?name=marcelo");
        HttpURLConnection connectionPostName = (HttpURLConnection) urlPostName.openConnection();

        connectionPostName.setRequestMethod("POST");

        int responseCodePost = connectionPostName.getResponseCode();
        connectionPostName.disconnect();



        URL urlDeleteName = new URL("http://localhost:5000/names?name=marcelo");
        HttpURLConnection connectionDeleteName = (HttpURLConnection) urlDeleteName.openConnection();

        connectionDeleteName.setRequestMethod("DELETE");

        byte[] bytes = connectionDeleteName.getInputStream().readAllBytes();
        String deleteName = new String(bytes);

        assertEquals("OK, marcelo deleted", deleteName);
    }

    @Test
    public void putRequestOnNameHandlerReturnsOKNameUpdated() throws IOException {

        URL urlPostName = new URL("http://localhost:5000/names?name=marcelo");
        HttpURLConnection connectionPostName = (HttpURLConnection) urlPostName.openConnection();

        connectionPostName.setRequestMethod("POST");

        int responseCodePost = connectionPostName.getResponseCode();
        connectionPostName.disconnect();




        URL urlPutName = new URL("http://localhost:5000/names?name=marcelo&newName=bianca");
        HttpURLConnection connectionPutName = (HttpURLConnection) urlPutName.openConnection();

        connectionPutName.setRequestMethod("PUT");


        byte[] bytes = connectionPutName.getInputStream().readAllBytes();
        String putName = new String(bytes);


        assertEquals("OK, name updated", putName);
    }


    }
