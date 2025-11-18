public abstract class CharacterClass {

    protected String className;
    protected int health;
    protected int damage;


    public CharacterClass(String className, int health, int damage) {
        this.className = className;
        this.health = health;
        this.damage = damage;
    }

    public int getBaseHealth() {
        return health;
    }

    public int getBaseDamage() {
        return damage;
    }

    public String getClassName() {
        return className;
    }

    public int specialAbility(int baseDamage) {
        return baseDamage;
    }

}
