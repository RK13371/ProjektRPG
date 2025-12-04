import java.util.HashMap;
import java.util.Map;
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
    private int round;
    private int gold = 0;
    private int attackCount = 0;

    private Map<String, Integer> inventory = new HashMap<>();

    private boolean isAutosaved = false;

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
        System.out.println("Złoto: " + gold);
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

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
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


    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public boolean spendGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
            return true;
        }
        return false;
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

    public void useItem(Item item) {
        System.out.println("Używasz " + item.getName());
        item.itemEffect(this);
    }

    public void addItemToInventory(String itemName) {
        inventory.put(itemName, inventory.getOrDefault(itemName, 0) + 1);
    }

    public boolean hasItem(String itemName) {
        return inventory.getOrDefault(itemName, 0) > 0;
    }

    public boolean useItemByName(String itemName) {
        if(!hasItem(itemName)) return false;

        Item item;
        switch (itemName) {
            case "Mikstura leczenia": item = new HealingPotion(); break;
            case "Mikstura siły": item = new StrengthPotion(); break;
            case "Mikstura szczęścia": item = new LuckPotion(); break;
            default: return false;
        }

        useItem(item);
        inventory.put(itemName, inventory.get(itemName) - 1);
        if(inventory.get(itemName) <= 0) inventory.remove(itemName);
        return true;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = new HashMap<>(inventory);
    }


    public boolean isAutosaved() {
        return isAutosaved;
    }

    public void setAutosaved(boolean autosaved) {
        isAutosaved = autosaved;
    }
}