import model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {

    private final MovieStore movieStore = new MovieStore();
    private final Movie harryPotter = new Movie("Harry Potter", "Rowling");
    private final Movie starWars = new Movie("Star Wars", "Shwimmer");
    private final Movie starTrek = new Movie("STAR Trek", "Shwimmer");
    private final Movie shawShank = new Movie("Shawshank Redemption", "Bob");
    private final Movie takeThat = new Movie("Take That", "Shwimmer");

    @Before
    public void setUp() throws Exception {
        movieStore.add(shawShank);
        movieStore.add(harryPotter);
        movieStore.add(harryPotter);
        movieStore.add(starWars);
        movieStore.add(starTrek);
        movieStore.add(takeThat);
    }

    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }
    @Test
    public void findsMoviesWhenTitlesArePartiallyMatchedCaseInsensitive() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("tar");

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starTrek, starWars));
    }
    @Test
    public void findsMoviesWhenDirectorExactlyMatches() throws Exception {
        List<Movie> results = movieStore.findByDirector("Shwimmer");

        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(starTrek, starWars, takeThat));
    }
}