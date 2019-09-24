package model;

import interfaces.DateTimeInterface;

public class MockDateTimeTest implements DateTimeInterface {

    @Override
    public String getDateTime() {
        return " - the time on the server is time on this date";
    }
}
