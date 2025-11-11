public abstract class CharacterClass {

    protected String name;
    protected int health;
    protected int damage;


    public CharacterClass(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public int getBaseHealth() {
        return health;
    }

    public int getBaseDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int specialAbility(int baseDamage) {
        return baseDamage;
    }
}
