package com.softserve.edu.teachua.data;

public enum Cities {
    KYIV_CITY("Київ"),
    KHARKIV_CITY("Харків");

    private Cities(String city) {
        // TODO Task 2: store the city name passed to the constructor.
    }

    public String getCity() {
        // TODO Task 2: return the stored city name.
        throw new UnsupportedOperationException("Implement Cities.getCity()");
    }

    @Override
    public String toString() {
        // TODO Task 2: return the city name.
        return name();
    }
}
