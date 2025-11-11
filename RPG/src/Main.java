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
        scanner.nextLine();

        Player player = new Player(name, klasa);
        player.showInfo();

        int runda = 1;

        while(player.isAlive()) {
            System.out.println("\n--- RUNDA " + runda + " ---");

            Enemy enemy = Enemy.randomEnemy(runda);
            System.out.println("Na twojej drodze staje: " + enemy.getName());

            Combat.fight(player, enemy);

            if(!player.isAlive()) {
                System.out.println("\n" + player.getName() + " został pokonany");
                break;
            }

            System.out.println();
            player.showInfo();

            System.out.println("Czy chcesz przejść dalej? (t/n)");
            String c = scanner.nextLine().toLowerCase();
            if(c.equals("n")) {
                player.showInfo();
                break;
            }

            runda++;
            player.resetHealth();
        }

        System.out.println("-----------");
        System.out.println("Koniec gry");


        scanner.close();
    }
}