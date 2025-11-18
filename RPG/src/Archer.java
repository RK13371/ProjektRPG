import java.util.Random;

public class Archer extends CharacterClass{

    Random random = new Random();

    public Archer(String name) {
        super(name, 60, 35);
    }

    @Override
    public int specialAbility(int baseDamage) {
        if(random.nextDouble() < 0.15) {
            return baseDamage * 2;
        }
        return baseDamage;
    }
}
