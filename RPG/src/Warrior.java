import java.util.Random;

public class Warrior extends CharacterClass{
    Random random = new Random();

    public Warrior(String name) {
        super(name, 120, 30);
    }

    @Override
    public int specialAbility(int baseDamage) {

        double chance = random.nextDouble();
        if(chance < 0.25) {
            System.out.println(getName() + " uderza mocnym atakiem");
            return baseDamage * 2;
        }
        return baseDamage;
    }

}
