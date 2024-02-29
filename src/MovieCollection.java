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
    public void seeListOfMovies() {
        for(Movie movie : movieList) {
            System.out.println(movie.toString());
            System.out.println("      Index:"+movieList.indexOf(movie));
        }
    }



   //searchMovie() bruges til det egentlige program. Der benyttes boolean således, at der kun sker en sysout af ingen film fundet.
    public void searchMovie(String searchTerm) {
       //For each loop leder gennem arraylist. Returnerer searchingMovies sammen med toString metode.
        boolean found = false;
        for(Movie searchingMovies : movieList) {
                if (searchingMovies.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                    System.out.println(searchingMovies.toString());
                    found = true;
                    //System.out.println("Plads: "+movieList.indexOf(searchingMovies)+" "+searchingMovies.getTitle()+"("+ searchingMovies.getYearCreated()+")");
                }
                /* //Kode erstattes med boolean variabel found, således at der kun sker en fejlbesked, og ikke hver gang for each loop itereres.
                else if(searchingMovies.getTitle().length() > 0) {
                    System.out.println("Ingen film i din samling matchede din søgning.");
                }

                 */

        }
        if(!found) { //Hvis boolean variabel er false returneres nedenstående printline.
            System.out.println("Ingen film i din samling matchede din søgning.");
        }
    }
    //Nedenstående kode bruges til unit testing. Kode er more or less kopieret fra unittesting opgaven fra 28. feb 2024.
    public Movie findMovie(String searchTerm) {
        for(Movie movie : movieList) {
            if(movie.getTitle().toLowerCase().equals(searchTerm.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }
    public ArrayList <Movie> searchMovieArray(String searchTerm) {
        ArrayList <Movie> resultArrayList = new ArrayList<>();
        for ( Movie movie : movieList) {
            if(movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                resultArrayList.add(movie);
            }
        }
        return resultArrayList;
    }


    public void editMovieAttributes(int index) {
        if (index < 0 || index >= movieList.size()) { //Hvis der ikke er et Movie objekt på det valgte index
            System.out.println("Der lader ikke til at være en film i din samling på det indtastede index.");
            return;
        }
        Scanner input = new Scanner(System.in);

        Movie valgtFilmIndex = movieList.get(index);
        System.out.println("Du har valgt "+valgtFilmIndex.getTitle()+"("+valgtFilmIndex.getYearCreated()+")");
        System.out.println("Hvilke elementer af din film ønsker du at redigere?");
        System.out.println("1: Titel");
        System.out.println("2: Instruktør");
        System.out.println("3: Genre");
        System.out.println("4: Længde i minutter");
        System.out.println("5: Farve");
        System.out.println("6. Udgivelsesår");

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Nuværende titel: "+movieList.get(index).getTitle());
                System.out.print("Nye titel: ");
                String newTitle = input.nextLine();
                movieList.get(index).setTitle(newTitle);
                System.out.println("Ændring gemt!");
                break;
            case 2:
                System.out.println("Nuværende instruktør: "+movieList.get(index).getDirector());
                System.out.print("Nye instruktør: ");
                String newDirector = input.nextLine();
                movieList.get(index).setDirector(newDirector);
                System.out.println("Ændring gemt!");
                break;
            case 3:
                System.out.println("Nuværende genre: "+movieList.get(index).getGenre());
                System.out.print("Nye genre: ");
                String newGenre = input.nextLine();
                movieList.get(index).setGenre(newGenre);
                System.out.println("Ændring gemt!");
                break;
            case 4:
                System.out.println("Nuværende længde i minutter: "+movieList.get(index).getLengthInMinutes() +" minutter");
                System.out.print("Nye længde i minutter: ");
                int newLength = input.nextInt();
                input.nextLine();
                movieList.get(index).setLengthInMinutes(newLength);
                System.out.println("Ændring gemt!");
                break;
            case 5:
                movieList.get(index).setInColor(false);
                System.out.println(movieList.get(index).getTitle()+"("+movieList.get(index).getYearCreated()+")"+" er hermed sat til ikke at være i farve.");
                System.out.println("Skriv ja, hvis "+movieList.get(index).getTitle()+"("+movieList.get(index).getYearCreated()+")"+" er i farve. Skriv nej, hvis filmen ikke er i farve.");
                String farveValg = input.next().toLowerCase();
                if (farveValg.equals("ja")) {
                    movieList.get(index).setInColor(true);
                }
                System.out.println("Ændring gemt!");
                break;
            case 6:
                System.out.println("Nuværende udgivelsesår: "+movieList.get(index).getYearCreated());
                System.out.println("Nye udgivelsesår: ");
                int newYear = input.nextInt();
                input.nextLine();
                movieList.get(index).setYearCreated(newYear);
                System.out.println("Ændring gemt!");
                break;
            default:
                System.out.println("Ingen ændringer blev gemt. Vælg venligst inden for menuen.");
        }
    }
}
