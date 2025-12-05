import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerGoldTest {


    @Test
    public void testGold() {
        CharacterClass cls = new Warrior(new ClassStats(120, 30, 0.25));
        Player player = new Player("Test", cls);
        player.addGold(50);
        assertEquals(50, player.getGold());


        // Wydanie 30 golda, zostaje 20
        boolean success = player.spendGold(30);
        assertTrue(success);
        assertEquals(20, player.getGold());

        // Fail przy próbie wydania 100, ma zostać 20
        boolean fail = player.spendGold(100);
        assertFalse(fail);
        assertEquals(20, player.getGold());
    }



}