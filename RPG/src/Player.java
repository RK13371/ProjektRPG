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
        System.out.println("Poziom: " + lvl);
        System.out.println("Punkty doświadczenia: " + xp + "/" + xpUp);
        System.out.println("Punkty życia: " + health);
        System.out.println("Punkty obrażeń: " + damage);
    }


    public String getName() {return name;}
    public int getHealth() {return health;}
    public int getDamage() {return damage;}
    public int getLvl() {return lvl;}

    public void setHealth(int health) {this.health = health;}
    public void setDamage(int damage) {this.damage = damage;}


    // SPRAWDZANIE CZY POSTAĆ/PRZECIWNIK ŻYJE
    boolean isAlive() {
        return health > 0;
    }

    // LOSOWANIE WARTOŚCI OBRAZEŃ
    public int getDamageValue() {
        int randomDamageValue = random.nextInt(11) - 5;
        int baseDamage = damage + randomDamageValue;
        return characterClass.specialAbility(baseDamage);
    }

    // OTRZYMYWANIE OBRAZEŃ
    public void takeDamage(int amount) {
        health -= amount;
        if(health < 0) {
            health = 0;
        }
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



}