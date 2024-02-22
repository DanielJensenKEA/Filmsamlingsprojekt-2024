import java.util.ArrayList;

public class MovieCollection {
   // private Movie [] filmSamling;
    //int count = 0;
    ArrayList<Movie> movieList;



    public MovieCollection() {
        //this.filmSamling = new Movie[5];
        movieList = new ArrayList<>();
    }


    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        movieList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre));
        //Bekræftelse på at det virker.
        System.out.println(movieList.get(movieList.size() -1).getTitle()+" er blevet tilføjet til listen.");
        for(Movie movie : movieList) {
            System.out.println(movie.toString());
        }
    }
    public void searchMovie(String searchTerm) {
        for(int i=0; i < movieList.size(); i++) {

            if(searchTerm.equals(movieList.get(i).getTitle())) {
                System.out.println("Titel:" + movieList.get(i).getTitle());
            }

        }

    }

    //Main laver metodekald til Controller
    /*
public String seeListOfMovies() {
    String movieListResult ="";
    for(Movie movie : movieList) {
        //System.out.println(movie.toString());
        movieListResult = movie.getTitle();
    }
    return movieListResult;
}

 */

}
