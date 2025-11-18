import java.util.InputMismatchException;
import java.util.Scanner;

public class Combat {

    private static final Scanner scanner = new Scanner(System.in);

    static void fight(Player player, Enemy enemy) {


        UI.fightStart(player, enemy);

        while(player.isAlive() && enemy.isAlive()) {

            int choice = UI.chooseAction();

            if (choice == 1) {
                int damage = player.getDamageValue();
                enemy.takeDamage(damage);
                UI.print(player.getName() + " zadaje " + damage + " obrażeń " + enemy.getName());
                player.increaseAttackCount();
            }
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
            }

            // SPRAWDZENIE CZY PRZECIWNIK NIE ŻYJE I WYJŚCIE Z PĘTLI
            if(!enemy.isAlive()) {
                UI.showHP(player, enemy);
                UI.print("\nPrzeciwnik pokonany!\n");
                UI.wygrana(player);
                player.addXP(50);
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
