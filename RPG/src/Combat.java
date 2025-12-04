import java.util.*;

public class Combat {

    static void fight(Player player, Enemy enemy) {


        UI.fightStart(player, enemy);

        while(player.isAlive() && enemy.isAlive()) {

            int choice = UI.chooseAction();

            // Zwykły atak
            if (choice == 1) {
                int damage = player.getDamageValue();
                enemy.takeDamage(damage);
                UI.print(player.getName() + " zadaje " + damage + " obrażeń " + enemy.getName());
                player.increaseAttackCount();
            }
            // Specjalny atak
            else if (choice == 2) {
                if(!player.canAbility()) {
                    UI.printCooldown(player);
                    continue;
                }

                int damage = player.specialAttack();
                enemy.takeDamage(damage);
                UI.print(player.getName() + " używa umiejętności specjalnej zadając "
                        + damage + " obrażeń " + enemy.getName());

                player.resetAttackCount();
            } else if (choice == 3) {
                // Sprawdzenie czy inv jest pusty
                if(player.getInventory().isEmpty()) {
                    UI.print("Nie posiadasz żadnych przedmiotów");
                    continue;
                }

                // Utworzenie listy przedmiotów
                Map<String, Integer> inv = player.getInventory();
                List<String> items = new ArrayList<>(inv.keySet());

                // Wyświetlenie ponumerowanej listy przedmiotów w inv
                UI.print("EKWIPUNEK");
                for(int i = 0; i < items.size(); i++) {
                    String itemName = items.get(i);
                    int n = inv.get(itemName);
                    UI.print((i+1) + ". " + itemName + " (" + n + ")");
                }
                UI.print("0. Wyjdź");


                // Wybór przedmiotu
                int itemChoice = UI.getInput(0, items.size());

                if(itemChoice == 0) {
                    continue;
                }


                String chosenItem = items.get(itemChoice - 1);
                boolean t = player.useItemByName(chosenItem);

                if(!t) {
                    UI.print("Nie użyto przedmiotu");
                    continue;
                }
                // Użycie i usunięcie przedmiotu z inv
                UI.print("Użyto: " + chosenItem);

            }

            // SPRAWDZENIE CZY PRZECIWNIK NIE ŻYJE I WYJŚCIE Z PĘTLI
            if(!enemy.isAlive()) {
                UI.showHP(player, enemy);
                UI.print("\nPrzeciwnik pokonany!\n");
                UI.wygrana(player);
                player.addXP(50);

                double dropChance = player.getRandom().nextDouble();
                if(dropChance < 0.25) {
                    double itemType = player.getRandom().nextDouble();
                    String itemName;
                    if(itemType < 0.5) {
                        itemName = "Mikstura leczenia";
                    }
                    else if(itemType < 0.8) {
                        itemName = "Mikstura siły";
                    }
                    else {
                        itemName = "Mikstura szczęścia";
                    }

                    player.addItemToInventory(itemName);
                    UI.print("Z przeciwnika wypadło: " + itemName);
                }

                int gold = enemy.getType().getGold();
                player.addGold(gold);
                System.out.println("Zdobywasz " + gold + " złota");



                break;
            }

            int enemyDamage = enemy.getDamageValue();
            player.takeDamage(enemyDamage);
            UI.print(enemy.getName() + " zadaje " + enemyDamage + " obrażeń " + player.getName());
            UI.showHP(player, enemy);

            System.out.println("-----------------------------------");
        }

        if(!player.isAlive()) {
            UI.przegrana(enemy);
        }





    }

}
