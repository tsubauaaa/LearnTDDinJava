import model.Movie;

import java.util.LinkedList;
import java.util.List;

public class MovieStore {
    List<Movie> movies = new LinkedList<Movie>();

    public List<Movie> findByPartialTitle(String partialTitle) {
        return findBy(movie -> movie.title().toUpperCase().contains(partialTitle.toUpperCase()));
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
        return findBy(movie -> movie.director().equals(director));
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        return findBy(movie -> movie.releaseYear() > from && movie.releaseYear() < to);
    }

    interface  Predicate{
        boolean matches(Movie movie);
    }
}
