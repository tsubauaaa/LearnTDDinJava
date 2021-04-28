import model.Movie;

import java.util.LinkedList;
import java.util.List;

public class MovieStore {
    List<Movie> movies = new LinkedList<Movie>();

    public List<Movie> findByPartialTitle(String partialTitle) {
        Predicate predicate = new Predicate() {
            @Override
            public boolean matches(Movie movie) {
                return movie.title().toUpperCase().contains(partialTitle.toUpperCase());
            }
        };
        return findBy(predicate);
    }

    private List<Movie> findBy(Predicate predicate) {
        List<Movie> result = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if (predicate.matches(movie)) {
                result.add(movie);
            }
        }
        return result;
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findByDirector(String director) {
        Predicate predicate = new Predicate() {
            public boolean matches(Movie movie) {
                return movie.director().equals(director);
            }
        };
        return findBy(predicate);
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        Predicate predicate = new Predicate() {
            @Override
            public boolean matches(Movie movie) {
                return movie.releaseYear() > from && movie.releaseYear() < to;
            }
        };
        return findBy(predicate);
    }

    interface  Predicate{
        boolean matches(Movie movie);
    }
}
