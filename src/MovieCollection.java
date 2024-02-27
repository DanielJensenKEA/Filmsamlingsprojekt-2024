import java.util.ArrayList;
import java.util.Scanner;

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
        //Nedenfor er demokode.
    }

    public void searchMovie(String searchTerm) {
       //For each loop leder gennem arraylist. Returnerer searchingMovies sammen med toString metode.
        for(Movie searchingMovies : movieList) {
            //Vi kigger på try catch næste uge :) og skal ikke bruge det i dag.
                if (searchingMovies.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                    System.out.println(searchingMovies.toString());
                    //System.out.println("Plads: "+movieList.indexOf(searchingMovies)+" "+searchingMovies.getTitle()+"("+ searchingMovies.getYearCreated()+")");
                }
                else if(movieList.isEmpty()) {
                    System.out.println("Ingen film i din samling matchede din søgning.");
                }
        }
    }
    public void editMovie(int selection, Movie element ) { //ufærdig og scuffed kode
        System.out.println("Vælg hvilken film du vil redigere");
        movieList.indexOf()
        movieList.set(selection, element);

    }

    public void editMovieMenu() {
        Scanner input = new Scanner(System.in);
        String menuChoice;
        int indexChoice;

        System.out.println("Angiv venligst, hvilket element du ønsker at redigere. Gyldige valg er: titel, director, yearCreated, ");
        menuChoice = input.next();

        //title, director, yearCreated, isInColor, lengthInMinutes, genre
        //if-statement afgør, hvad brugeren vil ændre

        if (menuChoice.toLowerCase().equals("title")) {

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
