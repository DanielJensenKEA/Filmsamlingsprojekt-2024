import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Vi kommenterer Moviecollection ud og tilføjer vores controller klasse.
        //MovieCollection o = new MovieCollection();
        Controller o = new Controller();

        //Start på While Loop, menu til bruger.
        final int SENTINEL = 2;
        int loopInput = 1;

        while (loopInput != SENTINEL ) {
            System.out.println("Velkommen til din filmsamling.");
            System.out.println("Tast 1 for at oprette en film");
            System.out.println("Tast 2 for at afslutte");
            loopInput = input.nextInt();
            input.nextLine();

            if(loopInput == 1) {
                //I nedenstående kode er der indsat input.nextLine efter hver int eller boolean variabel i et
                // forsøg på at redde programmet fra Scanner bug.

                System.out.println("Skriv titlen på filmen.");
                String title = input.nextLine();



                System.out.println("Skriv navnet på instruktøren.");
                String director = input.nextLine();
                System.out.println("Skriv årstallet på, hvornår filmen blev udgivet.");
                int yearCreated = input.nextInt();
                input.nextLine();

                System.out.println("Skriv, hvorvidt filmen er i farve eller ej. True/False.");
                boolean isInColor = input.nextBoolean();
                input.nextLine();

                System.out.println("Skriv varigheden af filmen i minutter.");
                int lengthInMinutes = input.nextInt();
                input.nextLine();

                System.out.println("Skriv genren.");
                String genre = input.next();

                o.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);



                //Kode er udkommenteret.
               // Movie[] test2 = o.getFilmSamling();
                //System.out.println(test2[0].getTitle() + "er tilføjet til listen.");
            }
            else {
                System.out.println("Du har afsluttet programmet.");
            }



        }

        //Bruger input til constructor


    }
}
