public class Controller {
    MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }


    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }
    public void seeListOfMovies() {
        for(Movie movie : movieCollection.movieList) {
            System.out.println(movie.toString());
        }

    }

    public void searchMovie(String searchTerm) {
        movieCollection.searchMovie(searchTerm);
    }
}
