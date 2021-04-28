package model;

import java.nio.charset.Charset;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
}
