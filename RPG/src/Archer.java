import java.util.Random;

public class Archer extends CharacterClass{

    private static final Random random = new Random();

    public Archer() {
        super("Łucznik", 60, 35);
    }

    @Override
    public int specialAbility(int baseDamage) {
        if(random.nextDouble() < 0.15) {
            return baseDamage * 2;
        }
        return baseDamage;
    }
}
