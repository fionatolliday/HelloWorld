package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import parser.QueryParser;
import Output.WriteResponse;
import model.Person;
import model.World;

import java.io.*;
import java.util.Map;

public class PersonHandler implements HttpHandler {

    private final World world;
    private String response;


    public PersonHandler(World world) {
        this.world = world;
    }


    @Override
    public void handle(HttpExchange request) throws IOException {

        switch (request.getRequestMethod()) {
            case "GET":
                response = getRequest();
                break;
            case "POST":
                response = postRequest(request);
                break;
            case "PUT":
                response = putRequest(request);
                break;
            case "DELETE":
                response = deleteRequest(request);
                break;
            default:
                notFound(request);
        }


        request.sendResponseHeaders(200, response.length());
        WriteResponse.writeResponse(request, response);
        request.close();
    }


    private String getRequest() {
        try {
            response = world.getNamesOfPeople().toString();
        } catch (Exception e) {
            response = " Exception thrown: " + e;
        }
        return response;
    }


    private String postRequest(HttpExchange request) {
        try {
            Person person = getPerson(request);
            world.getPersonStorage().addPerson(person);
            response = person.getName() + " added";
        } catch (Exception e) {
            response = "Could not be executed.  Exception thrown: " + e;
        }
        return response;
    }


    private String putRequest(HttpExchange request) {
        try {
            Person person = getPerson(request);
            world.getPersonStorage().changePerson(person, person);
            response = "OK, name updated";
        } catch (Exception e) {
            response = "Cannot proceed. Exception " + e;
        }
        return response;
    }


    private String deleteRequest(HttpExchange request) {
        try {
            Person person = getPerson(request);
            world.getPersonStorage().removePerson(person.getName());
            response = "OK, " + person + " deleted";
        } catch (Exception e) {
            response = "Cannot proceed. Exception " + e;
        }
        return response;
    }


    private void notFound(HttpExchange request) throws IOException {
        request.sendResponseHeaders(404, 0);
        String response = "model.Person not found. Please try again. ";
        WriteResponse.writeResponse(request, response);
    }


    private Person getPerson(HttpExchange request){
        Map<String, String> requestParams =
                QueryParser.queryParse(request.getRequestURI().getQuery());

        if (requestParams.containsKey("name")) {
                return new Person(requestParams.get("name"));
        }
        else {
            return new Person(requestParams.get("newName"));
        }
    }



}


