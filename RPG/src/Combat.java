import java.util.InputMismatchException;
import java.util.Scanner;

public class Combat {


    static void fight(Player player, Enemy enemy) {


        System.out.println("\nROZPOCZĘCIE WALKI");
        System.out.println(player.getName() + " VS " + enemy.getName());
        System.out.println();

        while(player.isAlive() && enemy.isAlive()) {

            int enemyDamage = enemy.getDamageValue();

            int choice = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Atak");
            System.out.println("2. Umiejętność specjalna");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Zły wybór ");
                scanner.nextLine();
                continue;
            }



            switch(choice) {
                case 1 -> {
                    // ZADANIE OBRAZEN PRZECIWNIKOWI PRZEZ POSTAĆ
                    int playerDamage = player.getDamageValue();
                    enemy.takeDamage(playerDamage);
                    System.out.println(player.getName() + " zadaje " + playerDamage + " obrażeń " + enemy.getName());

                    player.increaseAttackCount();
                }
                case 2 -> {
                    if(!player.canAbility()) {
                        System.out.println("Możesz użyć umiejętności specjalnej za " +
                                            (3-player.getAttackCount()) + " tury");
                        continue;
                    }

                    int playerDamage = player.specialAttack();
                    enemy.takeDamage(playerDamage);
                    System.out.println(player.getName() + " używa umiejętnośći specjalnej, zadaje "
                                      + playerDamage + " obrażeń " + enemy.getName());

                    player.resetAttackCount();
                }
            }




            // SPRAWDZENIE CZY PRZECIWNIK NIE ŻYJE I WYJŚCIE Z PĘTLI
            if(!enemy.isAlive()) {
                System.out.println(player.getName() + "=" + player.getHealth() + "HP | "
                        + enemy.getName() + "=" + enemy.getHealth() + "HP");

                System.out.println("\nPrzeciwnik pokonany\n");
                break;
            }

            // ZADANIE OBRAŻEŃ POSTACI PRZEZ PRZECIWNIKA
            player.takeDamage(enemyDamage);
            System.out.println(enemy.getName() + " zadaje " + enemyDamage + " obrażeń " + player.getName());

            System.out.println(player.getName() + "=" + player.getHealth() + "HP | "
                    + enemy.getName() + "=" + enemy.getHealth() + "HP");

            System.out.println("-----------------------------------");
        }

        // SPRAWDZENIE I WYPISANIE REZULTATU WALKI
        if(player.isAlive()) {
            System.out.println(player.getName() + " wygral walke");
            player.addXP(50);
        } else {
            System.out.println(enemy.getName() + " wygral walke");
        }




    }

}
