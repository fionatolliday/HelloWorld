package enums;

public enum RequestMethods {

    GET("GET"),
    PUT("PUT"),
    POST("POST"),
    DELETE("DELETE");

    private String requestMethod;

    RequestMethods(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

}
