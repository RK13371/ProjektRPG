public enum EnemyType {

    GOBLIN("Goblin", 35, 15, 15),
    TROLL("Troll", 120, 25, 30),
    GRYF("Gryf", 160, 45, 60);


    private String name;
    private int health;
    private int damage;
    private int gold;


    EnemyType(String name, int health, int damage, int gold) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.gold = gold;
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

    public int getGold() {
        return gold;
    }

}
