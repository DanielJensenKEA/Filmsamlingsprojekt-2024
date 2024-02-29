import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addMovie() {
        //Vi tester om en film tilføjes til arraylisten. Eftersom kun én film tilføjes forventer vi, at arraylistens størrelse kun er 1.
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        Movie movie = new Movie("Adams Æbler", "Jonathan B", 1998, true, 193, "horror");
        movieCollection.movieList.add(movie);

        //Act
        int actualSize = movieCollection.movieList.size();

        //Assert
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, actualSize);

    }
    @Test
    void searchManyMovies() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        Movie movie = new Movie("Adams Æbler", "Jonathan B", 1998, true, 193, "horror");
        Movie movie1 = new Movie("Adams Æbler 4000", "Jonathan B", 2000, true, 200, "action");
        Movie movie2 = new Movie("Ulrich Thomsen er Terminator", "Jonathan B", 2024, false, 500, "action");

        movieCollection.movieList.add(movie);
        movieCollection.movieList.add(movie1);
        movieCollection.movieList.add(movie2);
        //Act
        int actualSize = movieCollection.movieList.size();


        //Assert
        int expectedResult = 3;
        Assertions.assertEquals(expectedResult, actualSize);
    }
    @Test
    void searchMovieNoMovies() {
        //Arrange
        MovieCollection movc = new MovieCollection();
        Movie movie = new Movie("Adams Æbler", "Jonathan B", 1998, true, 193, "horror");
        Movie movie1 = new Movie("Batman", "Jonathan B", 1998, true, 193, "horror");
        movc.movieList.add(movie);
        movc.movieList.add(movie1);

        //Act
        Movie actualResult = movc.findMovie("Batman");
        //Assertions.assertNotNull(actualResult);

        //Assert
        assertNotEquals(movie.getTitle(), actualResult.getTitle());

    }

    @Test
    void searchMovieOneMovie() {
        //Arrange
        MovieCollection movc = new MovieCollection();
        Controller controller = new Controller();
        Movie movie = new Movie("Adams Æbler", "Jonathan B", 1998, true, 193, "horror");
        movc.movieList.add(movie);

        //Act
        Movie actualResult = movc.findMovie("Adams Æbler");


        //Assert
        assertEquals(movie.getTitle(), actualResult.getTitle());
    }

    @Test
    void searchMovieMoreMovies() {
        //Arrange
        MovieCollection movc = new MovieCollection();
        Controller controller = new Controller();
        Movie movie = new Movie("Adams Æbler", "Jonathan B", 1998, true, 193, "horror");
        Movie movie1 = new Movie("Adams Æbler 2", "Jonathan B", 1998, true, 193, "horror");
        movc.movieList.add(movie);
        movc.movieList.add(movie1);

        //Act
        Movie actualResult = movc.findMovie("Adams Æbler");

        //Assert
        assertEquals(movie.getTitle(), actualResult.getTitle());
    }



    @Disabled
    @Test
    void seeListOfMovies() {
    }

    @Test
    void movieDeletion() {
        //Arrange
        MovieCollection movc = new MovieCollection();
        Controller controller = new Controller();
        Movie movie = new Movie("Adams Æbler", "Jonathan B", 1998, true, 193, "horror");
        Movie movie1 = new Movie("Adams Æbler 2", "Jonathan B", 1998, true, 193, "horror");
        movc.movieList.add(movie);
        movc.movieList.add(movie1);

        //Act
        int actualSize = movc.movieList.size();
        movc.movieDeletion(0);

        //Assert
        int expectedResult = 1;
        Assertions.assertEquals(expectedResult, actualSize);
    }
}