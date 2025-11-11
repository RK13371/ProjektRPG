import java.util.Random;

public class Mage extends CharacterClass{

    Random random = new Random();

    public Mage(String name) {
        super(name, 70, 40);
    }

    @Override
    public int specialAbility(int baseDamage) {

        double chance = random.nextDouble();
        if(chance < 0.3) {
            System.out.println(getName() + " używa kuli ognia \uD83D\uDD25");
            return baseDamage * 2;
        }
        return baseDamage;
    }

}
