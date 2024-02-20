import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MovieCollection o = new MovieCollection();

        //Bruger input til constructor

        System.out.println("Skriv titlen på filmen.");
        String title = input.nextLine();

        System.out.println("Skriv navnet på instruktøren.");
        String director = input.nextLine();
        System.out.println("Skriv årstallet på, hvornår filmen blev udgivet.");
        int yearCreated = input.nextInt();
        System.out.println("Skriv, hvorvidt filmen er i farve eller ej. True/False.");
        boolean isInColor = input.nextBoolean();
        System.out.println("Skriv varigheden af filmen i minutter.");
        int lengthInMinutes = input.nextInt();
        System.out.println("Skriv genren.");
        String genre = input.next();

        o.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre );

        Movie[] test2 = o.getFilmSamling();
        System.out.println(test2[0].getTitle() + "er tilføjet til listen.");
    }
}
