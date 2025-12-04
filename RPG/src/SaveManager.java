import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

public class SaveManager {
    public static void saveGame(Player player, int runda, boolean showSaveMessage) {
        Save save = new Save();
        save.playerName = player.getName();
        save.className = player.getCharacterClass().getClassName();
        save.level = player.getLvl();
        save.xp = player.getXp();
        save.health = player.getHealth();
        save.attackCount = player.getAttackCount();
        save.round = runda;
        save.gold = player.getGold();
        save.inventory = player.getInventory();

        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("save.json");
            gson.toJson(save, writer);
            writer.close();
            if(showSaveMessage) {
                System.out.println("Gra została zapisana");
            }

        } catch (Exception e) {
            System.out.println("Błąd zapisu");
        }

    }

    public static Save loadGame() {
        try {
            FileReader reader = new FileReader("save.json");
            Gson gson = new Gson();

            Save save = gson.fromJson(reader, Save.class);

            reader.close();
            return save;
        } catch (Exception e) {
            System.out.println("Brak zapisu");
            return null;
        }
    }

    public static Player loadPlayer() {
        Save save = loadGame();
        if(save == null) {
            return null;
        }

        Map<String, ClassStats> stats = ConfigLoader.loadClassStats();

        CharacterClass cls;

        switch(save.className) {
            case "Wojownik" -> cls = new Warrior(stats.get("Wojownik"));
            case "Łucznik" -> cls = new Archer(stats.get("Łucznik"));
            case "Mag" -> cls = new Mage(stats.get("Mag"));
            default -> cls = new Warrior(stats.get("Wojownik"));
        }

        Player player = new Player(save.playerName, cls);
        player.setLvl(save.level);
        player.setXp(save.xp);
        player.setHealth(save.health);
        player.setAttackCount(save.attackCount);
        player.setRound(save.round);
        player.setGold(save.gold);
        player.setInventory(save.inventory);

        return player;
    }


}
