import model.Movie;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {
    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }

    @Test
    public void findsAMoviesWhenTitlesArePartiallyMatched() throws Exception {
        MovieStore movieStore = new MovieStore();
        Movie harryPotter = new Movie("Harry Potter");
        Movie starWars = new Movie("Star Wars");
        Movie starTrek = new Movie("STAR Trek");

        movieStore.add(new Movie("Shawshank Redemption"));
        movieStore.add(harryPotter);
        movieStore.add(starWars);
        movieStore.add(starTrek);

        List<Movie> results = movieStore.findByPartialTitle("tar");

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starTrek, starWars));
    }
}