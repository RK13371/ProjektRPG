import javax.swing.*;
import java.util.Map;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        Player player = null;
        AutoSaveThread autosave = null;
        int menuChoice = 0;

        Map<String, ClassStats> stats = ConfigLoader.loadClassStats();

        System.out.println("1. Nowa gra");
        System.out.println("2. Wczytaj grę");

        menuChoice = scanner.nextInt();
        scanner.nextLine();

        if(menuChoice == 2) {
            player = SaveManager.loadPlayer();
            if (player != null) {
                System.out.println("Zapis gry wczytany");
            } else {
                System.out.println("Przejście do nowej gry");
            }
        }

        if(player == null) {

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

            player = new Player(name, characterClass);
            player.setRound(1);


        }

        autosave = new AutoSaveThread(player);
        autosave.start();

        player.showInfo();


        int runda = player.getRound();

        while(player.isAlive()) {
            System.out.println("\n--- RUNDA " + runda + " ---");

            Enemy enemy = Enemy.randomEnemy(runda);
            System.out.println("Na twojej drodze staje: " + enemy.getName());

            Combat.fight(player, enemy);

            if(player.isAutosaved()) {
                System.out.println("Automatyczny zapis wykonany");
                player.setAutosaved(false);
            }

            if(!player.isAlive()) {
                System.out.println("\n" + player.getName() + " został pokonany");
                if(autosave != null) autosave.stopAutosave();;
                break;
            }

            System.out.println();
            player.showInfo();


            // SKLEP
            String choiceShop = "";
            while (!choiceShop.equals("t") && !choiceShop.equals("n")) {
                System.out.println("Czy chcesz odwiedzić sklep? (t/n)");
                choiceShop = scanner.nextLine().toLowerCase();
            }

            if(choiceShop.equals("t")) {
                Shop.showShop(player);
            }


            // ZAPIS GRY
            String saveChoice = "";
            while(!saveChoice.equals("t") && !saveChoice.equals("n")) {
                System.out.println("Zapisz gre (t/n)");
                saveChoice = scanner.nextLine().toLowerCase();
            }

            if(saveChoice.equals("t")) {
                player.setRound(runda);
                SaveManager.saveGame(player, runda, true);
            }


            // KONTYUNOWANIE GRY LUB WYJŚCIE
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
            player.setRound(runda);
            player.resetHealth();
        }


        System.out.println("-----------");
        System.out.println("Koniec gry");

        if(autosave != null) {
            autosave.stopAutosave();
        }

        scanner.close();

        }


}