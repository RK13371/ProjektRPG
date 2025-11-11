import java.util.Random;

public class Archer extends CharacterClass{

    Random random = new Random();

    public Archer(String name) {
        super(name, 60, 35);
    }

    @Override
    public int specialAbility(int baseDamage) {

        double chance = random.nextDouble();
        if(chance < 0.15) {
            System.out.println(getName() + " zadaje obrażenia krytyczne");
            return baseDamage * 2;
        }
        return baseDamage;
    }
}
