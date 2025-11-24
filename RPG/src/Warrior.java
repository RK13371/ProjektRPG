import java.util.Random;

public class Warrior extends CharacterClass{
    private static final Random random = new Random();

    public Warrior() {
        super("Wojownik", 120, 30);
    }

    @Override
    public int specialAbility(int baseDamage) {
        if(random.nextDouble() < 0.25) {
            return baseDamage * 2;
        }
        return baseDamage;
    }
}
