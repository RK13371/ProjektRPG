import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int damage;
    private EnemyType type;

    private Random random = new Random();


    public static Enemy randomEnemy(int runda) {
        Random rand = new Random();
        int losowanie = rand.nextInt(100);

        EnemyType type;
        if(losowanie < 70) {
            type = EnemyType.GOBLIN;
        }
        else if (losowanie < 90) {
            type = EnemyType.TROLL;
        }
        else {
            type = EnemyType.GRYF;
        }

        return new Enemy(type, runda);
    }


    public Enemy(EnemyType type, int runda) {
        this.type = type;
        this.name = type.getName();
        this.health = (int) (type.getHealth() * (1 + 0.1 * (runda-1)));
        this.damage = (int) (type.getDamage() * (1 + 0.05 * (runda-1)));
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

    public EnemyType getType() {
        return type;
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