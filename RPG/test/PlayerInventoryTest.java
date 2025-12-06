import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerInventoryTest {

    @Test
    public void testInventory() {
        CharacterClass cls = new Warrior(new ClassStats(120, 30, 0.25));
        Player player = new Player("Test", cls);

        player.addItemToInventory("Mikstura leczenia");
        assertTrue(player.hasItem("Mikstura leczenia"));

        boolean used = player.useItemByName("Mikstura leczenia");
        assertTrue(used);

        assertFalse(player.hasItem("Mikstura leczenia"));
    }

}
