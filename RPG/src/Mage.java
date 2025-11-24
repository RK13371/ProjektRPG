import java.util.Random;

public class Mage extends CharacterClass{

    private static final Random random = new Random();

    public Mage(ClassStats stats) {
        super("Mag", stats.health, stats.damage);
    }

    @Override
    public int specialAbility(int baseDamage) {
        if(random.nextDouble() < 0.3) {
            return baseDamage * 2;
        }
        return baseDamage;
    }

}
