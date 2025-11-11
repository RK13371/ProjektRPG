public enum EnemyType {

    GOBLIN("Goblin", 35, 15),
    TROLL("Troll", 120, 25),
    GRYF("Gryf", 220, 45);


    private String name;
    private int health;
    private int damage;


    EnemyType(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getDamage(){
        return damage;
    }

}
