package enums;

public enum StatusCodes {

    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NOT_FOUND(404);

    private int statusCode;

    StatusCodes(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

