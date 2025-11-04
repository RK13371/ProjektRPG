import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Podaj imie gracza: ");
        String name = scanner.nextLine();

        System.out.println("Wybierz klase postaci:");
        System.out.println("1. Wojownik (HP: 120, DMG: 25)");
        System.out.println("2. Łucznik (HP: 70, DMG: 35)");

        int klasa = scanner.nextInt();

        Player player = new Player(name, klasa);
        player.showInfo();

        Enemy enemy = new Enemy("Goblin", 70, 10);

        Combat.fight(player,enemy);

        System.out.println("Koniec walki");



    }



}