package Output;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;

public class WriteResponse {

    public static void writeResponse(HttpExchange request, String response) throws IOException {
        OutputStream os = request.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
