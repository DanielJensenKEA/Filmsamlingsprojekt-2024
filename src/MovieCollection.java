import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieCollection {
    // private Movie [] filmSamling;
    //int count = 0;
    ArrayList<Movie> movieList;


    public MovieCollection() {
        //this.filmSamling = new Movie[5];
        movieList = new ArrayList<>();
    }

    //Vores metode til at tilføje filmobjekter til vores arrayliste movieList.
    //En lille sysout besked til brugeren.
    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        movieList.add(new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre));
        //Vi printer en besked til brugeren, at filmobjektet er tilføjet til listen.
        System.out.println(movieList.get(movieList.size() - 1).getTitle() + " er blevet tilføjet til listen.");
    }

    public void seeListOfMovies() {
        //For loop, som itererer gennem movieList og returnerer hver lagrede film med concatenation af vores toString metode.
        for (Movie movie : movieList) {
            System.out.println(movie.toString());
            //Lidt homebrew, så bruger kan se filmenes indexplads, når de ser listen. Optræder til sidst i filmens attributter. Mellemrum i sysout er designvalg for at gøre det lettere overskueligt.
            //Samme indrykning er endvidere foretaget i toString metoden, så det ser lidt pænere ud.
            System.out.println("      Index:" + movieList.indexOf(movie));
        }
    }


    //searchMovie() bruges til det egentlige program. Der benyttes boolean således, at der kun sker en sysout af ingen film fundet.
    //Forhindre, at der sker sysout fejlbesked for hver iteration, hvor der ikke returneres et resultat i overensstemmelse med søgekriteriet.
    public void searchMovie(String searchTerm) {
        //For each loop leder gennem arraylist. Returnerer searchingMovies sammen med toString metode.
        boolean found = false;
        for (Movie searchingMovies : movieList) {
            if (searchingMovies.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println(searchingMovies.toString());
                found = true;
            }
        }
        if (!found) { //Hvis boolean variabel er false returneres nedenstående printline.
            System.out.println("\nIngen film i din samling matchede din søgning.");
        }
    }


    //Nedenstående kode bruges til unit testing. Kode er more or less kopieret fra unittesting opgaven fra 28. feb 2024.
    public Movie findMovie(String searchTerm) {
        for (Movie movie : movieList) {
            if (movie.getTitle().toLowerCase().equals(searchTerm.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    //Nedenstående metode searchMovieArray lykkedes ikke i, at returnere en arrayliste til brugeren. Den returnerer faktisk ikke noget.
    //Metoden er konstrueret med hjælp fra underviser den 29. februar 2024. Der blev ikke nået at få oplysning om, hvorfor den ikke returnerede.
    //Metoden antages at være skrevet korrekt, men eftersom den ikke fungerer efter hensigt er den ikke taget i brug af programmet.
    //I stedet benyttes metoden searchMovie() i forbindelse med programmets søgefunktion.
    public ArrayList<Movie> searchMovieArray(String searchTerm) {
        ArrayList<Movie> resultArrayList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                resultArrayList.add(movie);
            }
        }
        return resultArrayList;
    }

    public void movieDeletion(int index) { //User Story 11 - fjerne film fra listen.
        Scanner input = new Scanner(System.in);
        try {
            if (index < 0 || index >= movieList.size()) { //Hvis der vælges et index mindre end 0 eller højere end movieLists størrelse sker der en sysout besked.
                System.out.println("Ugyldigt index valg. Vælg venligst inden for de oplyste værdier.");
            }
            Movie valgtFilmIndex = movieList.get(index); //Vi gemmer indtastede indexværdi som valgtFilmIndex. Det gør vi for en lettere tilgang til sysout beskeder for brugervenlighed.

            System.out.println("Du har valgt " + valgtFilmIndex.getTitle() + " og ønsker at slette denne.");
            System.out.println("Ønsker du at fortsætte? Tast Ja for at fortsætte, nej for at afslutte. Dit valg kan ikke fortrydes.");
            String gaffelValg = input.nextLine().toLowerCase();

            //Vi vil gerne have, at brugere bekræfter deres valg om at slette en film, eftersom det sandsynligvis ikke er muligt at
            //hente et slettet movie objekt efter sletning.
            if (gaffelValg.equals("ja")) { //Hvis bruger skriver ja, er valget bekræftet.
                System.out.println("Film slettet: "+valgtFilmIndex.getTitle());
                movieList.remove(index);
            } else { //Hvis input ikke er ja, er der ingen grund til at foretage nogle ændringer. Bruger sendes tilbage.
                System.out.println("Ingen film slettes. Du sendes tilbage til menuen.");
            }
        }
        catch (Exception e) { //Vi laver Exception e for at fange flest mulige exceptions, så programmet ikke crasher i overensstemmelse med user stories.
            System.out.println("Der skete en fejl. "+e.getMessage());
        }
    }
    public void movieDeletionUNITTESTING(int index) { //User Story 11 - fjerne film fra listen. UNITTESTING KUN. Se forklaring i kommentar nedenfor.
        Scanner input = new Scanner(System.in);
        try {
            if (index < 0 || index >= movieList.size()) {
                System.out.println("Ugyldigt index valg. Vælg venligst inden for de oplyste værdier.");
            }
            Movie valgtFilmIndex = movieList.get(index);

            System.out.println("Du har valgt " + valgtFilmIndex.getTitle() + " og ønsker at slette denne.");
            System.out.println("Ønsker du at fortsætte? Tast Ja for at fortsætte, nej for at afslutte.");

            movieList.remove(index);
            //Nedenstående er udkommenteret, så unit testing af metoden kan ske, eftersom du ikke kan skrive i konsol ved unittesting.
            /*
            String gaffelValg = input.nextLine().toLowerCase();

            if (gaffelValg.equals("ja")) {
                movieList.remove(index);
                System.out.println("Film slettet.");
            } else {
                System.out.println("Ingen film slettes. Du sendes tilbage til menuen.");
            }
        }
             */
        }
        catch (Exception e) {
            System.out.println("Der skete en fejl.");
        }
    }
    public void editMovieAttributes(int index) {
        Scanner input = new Scanner(System.in);
        try {
            if (index < 0 || index >= movieList.size()) { //Hvis der ikke er et Movie objekt på det valgte index
                System.out.println("Der lader ikke til at være en film i din samling på det indtastede index.");
                return;
            }
            Movie valgtFilmIndex = movieList.get(index); //Vi gemmer indtastede index som valgtFilmIndex for sysout brugervenlighed.
            System.out.println("Du har valgt " + valgtFilmIndex.getTitle() + "(" + valgtFilmIndex.getYearCreated() + ")");
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
                //Der er blevet brugt switch-case her, egentlig fordi det var et IntelliJ forslag. Tænkte det var ok, når nu
                //vi brugte if-sætninger i vores startProgram. If-sætninger kunne tillige løse opgaven i nærværende metode
                //men tænkte, at det kunne være en fordel at bruge begge måder at håndtere menunavigation i et akademisk henseende :)
                //på forhånd undskyld, Edith.
                case 1:
                    //I hver case har vi et display af Nuværende titel osv. for brugervenlighed. Vi vil gerne sikre os, at
                    //brugeren ved, hvad der er programmets nærværende fokus.
                    System.out.println("Nuværende titel: " + movieList.get(index).getTitle());
                    System.out.print("Nye titel: ");
                    String newTitle = input.nextLine();
                    //Her bruger vi vores settermetode til at sætte den nye titel, der er indtastede af brugeren til String newTitle.
                    //I de øvrige cases sker samme fremgangsmåde ved at redigere i et eksisterende movieobjekt ved hjælp af settermetoder.
                    movieList.get(index).setTitle(newTitle);
                    System.out.println("Ændring gemt!");
                    break;
                case 2:
                    System.out.println("Nuværende instruktør: " + movieList.get(index).getDirector());
                    System.out.print("Nye instruktør: ");
                    String newDirector = input.nextLine();
                    movieList.get(index).setDirector(newDirector);
                    System.out.println("Ændring gemt!");
                    break;
                case 3:
                    System.out.println("Nuværende genre: " + movieList.get(index).getGenre());
                    System.out.print("Nye genre: ");
                    String newGenre = input.nextLine();
                    movieList.get(index).setGenre(newGenre);
                    System.out.println("Ændring gemt!");
                    break;
                case 4:
                    System.out.println("Nuværende længde i minutter: " + movieList.get(index).getLengthInMinutes() + " minutter");
                    System.out.print("Nye længde i minutter: ");
                    int newLength = input.nextInt();
                    input.nextLine();
                    movieList.get(index).setLengthInMinutes(newLength);
                    System.out.println("Ændring gemt!");
                    break;
                case 5:
                    //Lidt ekstra brugervenlighed i denne case. Boolean var lidt besværligt at forestille sig, at håndtere
                    //på denne måde.
                    movieList.get(index).setInColor(false); //Vi starter blot med at sætte inColor til false. Der er en
                    //vis antagelse(lidt farligt måske :) ) om, at brugeren ved, hvad de vil foretage sig her.
                    //Hvis brugeren ved, at filmen skal sættes i farve vil de skrive ja, hvorved inColor sættes til true.
                    //Såfremt brugeren ikke skriver noget eller ikke ønsker at redigere alligevel vil filmen sættes til false.
                    //En vis svaghed i denne del af programmet. Kan bruge videre arbejde for at maksimere potentialet.
                    System.out.println(movieList.get(index).getTitle() + "(" + movieList.get(index).getYearCreated() + ")" + " er hermed sat til ikke at være i farve.");
                    System.out.println("Skriv ja, hvis " + movieList.get(index).getTitle() + "(" + movieList.get(index).getYearCreated() + ")" + " er i farve. Skriv nej, hvis filmen ikke er i farve.");
                    String farveValg = input.next().toLowerCase();
                    if (farveValg.equals("ja")) {
                        movieList.get(index).setInColor(true);
                    }
                    System.out.println("Ændring gemt!");
                    break;
                case 6:
                    System.out.println("Nuværende udgivelsesår: " + movieList.get(index).getYearCreated());
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
        catch(Exception e)  {
            System.out.println("Der skete en fejl, prøv venligst igen.");
            input.nextLine();
            //Nedenstående linjer er indsat, eftersom der var nogle problemer med et infinite loop.
            //Lidt internet hjælp er benyttet her.
            input.next();

            System.out.println("Tryk enter for at fortsætte.");
            input.nextLine();
        }

    }
}
