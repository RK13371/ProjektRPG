public class Combat {

    static void fight(Player player, Enemy enemy) {
        System.out.println("\nROZPOCZĘCIE WALKI");
        System.out.println(player.getName() + " VS " + enemy.getName());
        System.out.println();

        while(player.isAlive() && enemy.isAlive()) {

            int playerDamage = player.getDamageValue();
            int enemyDamage = enemy.getDamageValue();

            enemy.takeDamage(playerDamage);
            System.out.println(player.getName() + " zadaje " + playerDamage + " obrażeń " + enemy.getName());

            if(!enemy.isAlive()) {
                System.out.println(player.getName() + "=" + player.getHealth() + "HP | "
                        + enemy.getName() + "=" + enemy.getHealth() + "HP");
                System.out.println("\nPrzeciwnik pokonany");
                break;
            }

            player.takeDamage(enemyDamage);
            System.out.println(enemy.getName() + " zadaje " + enemyDamage + " obrażeń " + player.getName());

            System.out.println(player.getName() + "=" + player.getHealth() + "HP | "
                    + enemy.getName() + "=" + enemy.getHealth() + "HP");

            System.out.println("-----------------------------------");
        }

        if(player.isAlive()) {
            System.out.println(player.getName() + " wygral walke");
            player.getXP(50);
        } else {
            System.out.println(enemy.getName() + " wygral walke");
        }

        System.out.println("test");


    }

}
