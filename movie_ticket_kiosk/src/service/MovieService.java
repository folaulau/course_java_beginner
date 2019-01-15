package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Movie;

public class MovieService {

	private Map<String,Movie> movies;
	
	MovieService(){
		movies = new HashMap<>();
		movies.put("Batman",new Movie("Batman", 12.50, Arrays.asList(new Date())));
		movies.put("Ironman",new Movie("Ironman", 12.50, Arrays.asList(new Date())));
		movies.put("Captain America",new Movie("Captain America", 12.50, Arrays.asList(new Date())));
		movies.put("Spiderman",new Movie("Spiderman", 14.50, Arrays.asList(new Date())));
		movies.put("Avengers",new Movie("Avengers", 12.50, Arrays.asList(new Date())));
		movies.put("Superman",new Movie("Superman", 13.50, Arrays.asList(new Date())));
	}
	
	public List<Movie> getAll(){
		return new ArrayList<>(movies.values());
	}
	
	public Movie getMovieByName(String name){
		return movies.get(name);
	}
	
}
