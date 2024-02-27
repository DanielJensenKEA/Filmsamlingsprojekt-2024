import java.util.Scanner;

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
            System.out.println("      Index:"+movieCollection.movieList.indexOf(movie));
        }

    }

    public void searchMovie(String searchTerm) {
        movieCollection.searchMovie(searchTerm);
    }

    public void editMovieMenu(int index) {
        movieCollection.editMovieAttributes(index);
    }


    public void displayMovieIndex() { //Bruges bare til at vise titlen på en film og dets tilhørende indexplads for at gøre det lettere for brugeren at navigere
        //Dette display vises, når man ønsker at lave en redigering af en allerede eksisterende film.
        for(Movie movie : movieCollection.movieList) {
            System.out.println(movie.getTitle()+"("+"Index: "+movieCollection.movieList.indexOf(movie)+")");
        }
    }


}
