import java.util.Random;

public class Mage extends CharacterClass{

    Random random = new Random();

    public Mage(String name) {
        super(name, 70, 40);
    }

    @Override
    public int specialAbility(int baseDamage) {
        if(random.nextDouble() < 0.3) {
            return baseDamage * 2;
        }
        return baseDamage;
    }

}
