import java.util.Random;

public class Warrior extends CharacterClass{
    private static final Random random = new Random();


    public Warrior(ClassStats stats) {
        super("Wojownik", stats.health, stats.damage);
    }

    @Override
    public int specialAbility(int baseDamage) {
        if(random.nextDouble() < 0.25) {
            return baseDamage * 2;
        }
        return baseDamage;
    }
}
