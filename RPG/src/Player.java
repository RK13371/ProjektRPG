import java.util.Scanner;
import java.util.Random;

public class Player {

    private Random random = new Random();

    private String name;
    private int health;
    private int damage;
    private CharacterClass characterClass;

    private int lvl;
    private int xp;
    private int xpUp;

    private int attackCount = 0;


    Player(String name, CharacterClass characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        this.health = characterClass.getBaseHealth();
        this.damage = characterClass.getBaseDamage();

        this.lvl = 1;
        this.xp = 0;
        this.xpUp = 100;
    }


    // STATYSTYKI
    public void showInfo() {
        System.out.println("Imie postaci: " + name);
        System.out.println("Klasa: " + characterClass.className);
        System.out.println("Poziom: " + lvl);
        System.out.println("Punkty doświadczenia: " + xp + "/" + xpUp);
        System.out.println("Punkty życia: " + health);
        System.out.println("Punkty obrażeń: " + damage);
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpUp() {
        return xpUp;
    }

    public void setXpUp(int xpUp) {
        this.xpUp = xpUp;
    }

    public int getAttackCount() {
        return attackCount;
    }

    public void setAttackCount(int attackCount) {
        this.attackCount = attackCount;
    }



    // SPRAWDZANIE CZY POSTAĆ/PRZECIWNIK ŻYJE
    boolean isAlive() {
        return health > 0;
    }

    // LOSOWANIE WARTOŚCI OBRAZEŃ
    public int getDamageValue() {
        int randomDamageValue = random.nextInt(11) - 5;
        return damage + randomDamageValue;
    }

    public int specialAttack() {
        int randomDamageValue = random.nextInt(11) - 5;
        int base = damage + randomDamageValue;
        return characterClass.specialAbility(base);
    }

    // OTRZYMYWANIE OBRAZEŃ
    public void takeDamage(int amount) {
        health -= amount;
        if(health < 0) {
            health = 0;
        }
    }

    public void resetAttackCount() {
        attackCount = 0;
    }

    public void resetHealth() {
        setHealth(characterClass.getBaseHealth() + lvl * 10);
    }

    // OTRZYMYWANIE PUNKTÓW DOŚWIADCZENIA
    public void addXP(int pd) {
        xp += pd;
        System.out.println(name + " zdobywa " + xp + " punktów doświadczenia");

        if(xp >= xpUp) {
            levelUp();
        }
    }

    // OTRZYMYWANIE POZIOMU
    public void levelUp() {
        xp -= xpUp;
        lvl++;
        xpUp += 50;

        health += 10;
        damage += 4;

        System.out.println(name + " awansował na " + lvl + " poziom");
        System.out.println("HP=" + health + " | " + "DMG=" + damage);
    }


    public void increaseAttackCount() {
        attackCount++;
    }

    public boolean canAbility() {
        return attackCount >= 3;
    }


}