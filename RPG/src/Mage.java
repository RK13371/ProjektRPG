import java.util.Random;

public class Mage extends CharacterClass{

    private static final Random random = new Random();

    public Mage() {
        super("Mag", 70, 40);
    }

    @Override
    public int specialAbility(int baseDamage) {
        if(random.nextDouble() < 0.3) {
            return baseDamage * 2;
        }
        return baseDamage;
    }

}
