import java.util.Scanner;

public class Player {

    private String name;
    private int health;
    private int damage;
    private int characterClass;

    static final int Warrior = 1;
    static final int Archer = 2;


    Player(String name, int characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        setClass();
    }


    void setClass() {
        if(characterClass == 1) {
            health = 120;
            damage = 25;
        }
        else if(characterClass == 2) {
            health = 70;
            damage = 35;
        }
        else {
            health = 100;
            damage = 20;
        }

    }



    boolean isAlive() {
        return health > 0;
    }

    public void showInfo() {
        System.out.println("Imie postaci: " + name);
        System.out.println("Punkty życia: " + health);
        System.out.println("Punkty obrażeń: " + damage);
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if(health < 0) {
            health = 0;
        }
    }



}