import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

//class MyNameHandler implements HttpHandler {
//    @Override
//    public void handle(HttpExchange t) throws IOException {
//        PersonProcessor processor = new PersonProcessor();
//
//        processor.addPerson(new Person("renae"));
//
//        String response = processor.listOfPeopleInWorld(processor.people).toString();
//        t.sendResponseHeaders(200, response.length());
//        OutputStream os = t.getResponseBody();
//        os.write(response.getBytes());
//        os.close();
//    }
//
//}

