import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerXPTest {

    @Test
    public void testLevelUp() {
        CharacterClass cls = new Warrior(new ClassStats(120, 30, 0.25));
        Player player = new Player("Test", cls);

        player.addXP(100);

        assertEquals(2, player.getLvl());
        assertEquals(150, player.getXpUp());
        assertEquals(130, player.getHealth());
        assertEquals(34, player.getDamage());
    }

}
