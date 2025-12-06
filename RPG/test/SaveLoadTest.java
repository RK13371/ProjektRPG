import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaveLoadTest {

    @Test
    public void saveLoad() {
        CharacterClass cls = new Warrior(new ClassStats(120, 30, 0.25));
        Player player = new Player("Test", cls);
        player.addGold(100);
        player.addItemToInventory("Mikstura szczęścia");

        SaveManager.saveGame(player, 1, false);
        Player loaded = SaveManager.loadPlayer();

        assertNotNull(loaded);
        assertEquals(100, loaded.getGold());
        assertTrue(loaded.hasItem("Mikstura szczęścia"));
    }
}
