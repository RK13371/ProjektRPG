public class Combat {

    static void fight(Player player, Enemy enemy) {
        System.out.println("\nROZPOCZĘCIE WALKI");
        System.out.println(player.getName() + " VS " + enemy.getName());
        System.out.println();

        while(player.isAlive() && enemy.isAlive()) {

            int playerDamage = player.getDamageValue();
            int enemyDamage = enemy.getDamageValue();

            // ZADANIE OBRAZEN PRZECIWNIKOWI PRZEZ POSTAĆ
            enemy.takeDamage(playerDamage);
            System.out.println(player.getName() + " zadaje " + playerDamage + " obrażeń " + enemy.getName());

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
