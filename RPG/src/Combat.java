public class Combat {

    static void fight(Player player, Enemy enemy) {
        System.out.println("-----------------------------------");

        while(player.isAlive() && enemy.isAlive()) {
            enemy.health -= player.damage;
            System.out.println(player.name + " zadaje " + player.damage + " obrażeń " + enemy.name);

            if(!enemy.isAlive()) {
                System.out.println("Przeciwnik pokonany");
                break;
            }

            player.health -= enemy.damage;
            System.out.println(enemy.name + " zadaje " + enemy.damage + " obrażeń " + player.name);

            System.out.println(player.name + "=" + player.health + "HP | "
                    + enemy.name + "=" + enemy.health + "HP");

            System.out.println("-----------------------------------");
        }

        if(player.isAlive()) {
            System.out.println(player.name + " wygral walke");
        } else {
            System.out.println(enemy.name + " wygral walke");
        }


    }

}
