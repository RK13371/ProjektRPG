public class Combat {

    static void fight(Player player, Enemy enemy) {
        System.out.println("-----------------------------------");

        while(player.isAlive() && enemy.isAlive()) {
            enemy.takeDamage(player.getDamage());
            System.out.println(player.getName() + " zadaje " + player.getDamage() + " obrażeń " + enemy.getName());

            if(!enemy.isAlive()) {
                System.out.println("Przeciwnik pokonany");
                break;
            }

            player.takeDamage(enemy.getDamage());
            System.out.println(enemy.getName() + " zadaje " + enemy.getDamage() + " obrażeń " + player.getName());

            System.out.println(player.getName() + "=" + player.getHealth() + "HP | "
                    + enemy.getName() + "=" + enemy.getHealth() + "HP");

            System.out.println("-----------------------------------");
        }

        if(player.isAlive()) {
            System.out.println(player.getName() + " wygral walke");
        } else {
            System.out.println(enemy.getName() + " wygral walke");
        }


    }

}
