import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);


    public static void print(String p) {
        System.out.println(p);
    }

    public static void fightStart(Player player, Enemy enemy) {
        System.out.println("ROZPOCZĘCIE WALKI");
        System.out.println(player.getName() + " VS " + enemy.getName());
        System.out.println();
    }

    public static void showHP(Player player, Enemy enemy) {
        System.out.println(player.getName() + "=" + player.getHealth() + "HP | "
                + enemy.getName() + "=" + enemy.getHealth() + "HP");
    }

    public static void przegrana(Enemy enemy) {
        System.out.println(enemy.getName() + " wygrał walkę");
    }

    public static void wygrana(Player player) {
        System.out.println(player.getName() + " wygrał walkę");
    }

    public static void printCooldown(Player player) {
        System.out.println("Możesz użyć umiejętności specjalnej za " +
                (3-player.getAttackCount()) + " tury");
    }

    public static int chooseAction() {
        System.out.println("1. Atak");
        System.out.println("2. Umiejętność specjalna");
        System.out.println("3. Użyj przedmiotu");
        return getInput(1, 3);
    }

    public static int getInput(int x, int y) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();

                if(value >= x && value <= y) {
                    return value;
                } else {
                    System.out.println("Zły wybór");
                }


            } catch (InputMismatchException e) {
                System.out.println("Zły wybór");
                scanner.nextLine();
            }
        }
    }

}
