import java.util.Random;

public class Enemy {
    private final String name;
    private int health;
    private int damage;

    private Random random = new Random();

    Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamageValue() {
        int randomDamageValue = random.nextInt(11) - 5;
        return damage + randomDamageValue;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }


}