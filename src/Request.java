import enums.RequestMethods;
import java.util.Map;

public class Request {

    private RequestMethods requestMethod;
    private String path;
    private Map<String, String> queryParams;

    public Request(RequestMethods requestMethod, String path, Map<String, String> queryParams){
        this.requestMethod = requestMethod;
        this.path = path;
        this.queryParams = queryParams;
    }


    public RequestMethods getRequestMethod() {
        return requestMethod;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }
}
