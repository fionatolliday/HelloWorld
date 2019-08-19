import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import enums.StatusCodes;

import java.io.*;
import java.util.Map;

public class PersonHandler implements HttpHandler {

    private final World world;

    public PersonHandler(World world) {
        this.world = world;
    }

    @Override
    public void handle(HttpExchange request) throws IOException {

        switch (request.getRequestMethod()) {
            case "GET":
                getRequest(request);
                break;
            case "POST":
                postRequest(request);
                break;
            case "PUT":
                putRequest(request);
                break;
            case "DELETE":
                deleteRequest(request);
                break;
            default:
                notFound(request);
        }

        request.close();
    }

    private void getRequest(HttpExchange request) throws IOException {
        String response;

        try {
            response = world.getNamesOfPeople().toString();
        } catch (Exception e) {
            response = StatusCodes.NOT_FOUND +"Exception thrown: " + e;
        }

        request.sendResponseHeaders(200, response.length());
        WriteResponse.writeResponse(request, response);
    }

    private void postRequest(HttpExchange request) throws IOException {
        String response;
        try {
            world.storage.addPerson(getPersonName(request));
            response = StatusCodes.ACCEPTED + " Person added";
        } catch (Exception e) {
            response = "Could not be executed.  Exception thrown: " + e;
        }

        request.sendResponseHeaders(200, response.length());
        WriteResponse.writeResponse(request, response);
    }


    private void putRequest(HttpExchange request) throws IOException {
        String response;
        try {
            world.storage.changePerson(getPersonName(request), getPersonNameNew(request));
            response = "OK, person updated";
        } catch (Exception e) {
            response = "Cannot be found";
        }

        request.sendResponseHeaders(200, response.length());
        WriteResponse.writeResponse(request, response);
    }

    private void deleteRequest(HttpExchange request) throws IOException {
        String response;
        try {
            world.storage.removePerson(getPersonName(request).getName());
            response = "OK person deleted";
        } catch (Exception e) {
            response = "Cannot be found";
        }

        request.sendResponseHeaders(200, response.length());
        WriteResponse.writeResponse(request, response);
    }

    private void notFound(HttpExchange request) throws IOException {
        request.sendResponseHeaders(404, 0);
        String response = "Person not found. Please try again. ";
        WriteResponse.writeResponse(request, response);
    }

    private Person getPersonName(HttpExchange request) {
        Map<String, String> requestParams =
                QueryParser.queryParse(request.getRequestURI().getQuery());
        return new Person(requestParams.get("name"));
    }

    private Person getPersonNameNew(HttpExchange request) {
        Map<String, String> requestParams =
                QueryParser.queryParse(request.getRequestURI().getQuery());
        return new Person(requestParams.get("newName"));
    }
}


