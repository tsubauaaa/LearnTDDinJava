package model;

public class Movie {
    private String title;
    private String director;

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public String title() {
        return title;
    }

    public String director() {
        return director;
    }
}
