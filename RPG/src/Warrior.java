import java.util.Random;

public class Warrior extends CharacterClass{
    Random random = new Random();

    public Warrior(String name) {
        super(name, 120, 30);
    }

    @Override
    public int specialAbility(int baseDamage) {
        if(random.nextDouble() < 0.25) {
            return baseDamage * 2;
        }
        return baseDamage;
    }
}
