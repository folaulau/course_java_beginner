package movie_ticket_kiosk;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Movie;
import service.ProductService;

class MovieServiceTest {

	ProductService movieService = new ProductService();
	
	@Test
	void testGetAllMovies() {
		List<Movie> ms = movieService.getAllMovies();
		
		for(Movie movie : ms) {
			System.out.println(movie.toString());
		}
	}

}
