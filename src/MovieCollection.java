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

    }



/*
    public Movie[] getFilmSamling() {
        return filmSamling;
    }

 */
}
