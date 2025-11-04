public class Enemy {
    String name;
    int health;
    int damage;

    Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }


    boolean isAlive() {
        return health > 0;
    }



}