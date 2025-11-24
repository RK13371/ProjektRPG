import java.util.Map;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        Map<String, ClassStats> stats = ConfigLoader.loadClassStats();


        System.out.print("Podaj imie gracza: ");
        String name = scanner.nextLine();

        System.out.println("Wybierz klase postaci:");
        System.out.println("1. Wojownik (HP: 120, DMG: 30)");
        System.out.println("2. Łucznik (HP: 60, DMG: 35)");
        System.out.println("3. Mag (HP: 70 , DMG: 40)");

        int klasa = scanner.nextInt();
        scanner.nextLine();

        CharacterClass characterClass;

        switch(klasa) {
            case 1 -> characterClass = new Warrior(stats.get("Wojownik"));
            case 2 -> characterClass = new Archer(stats.get("Łucznik"));
            case 3 -> characterClass = new Mage(stats.get("Mag"));
            default -> {
                characterClass = new Warrior(stats.get("Wojownik"));
            }
        }


        Player player = new Player(name, characterClass);
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

            String c = "";


            while(!c.equals("t") && !c.equals("n")) {
                System.out.println("Czy chcesz przejść dalej? (t/n)");
                c = scanner.nextLine().toLowerCase();

                if(!c.equals("t") && !c.equals("n")) {
                    continue;
                }
            }

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