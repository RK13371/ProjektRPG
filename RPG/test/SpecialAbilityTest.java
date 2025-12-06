import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpecialAbilityTest {

    @Test
    public void testSpecialAbility() {
        CharacterClass cls = new Warrior(new ClassStats(120, 30, 0.25));

        int base = 40;
        int result = cls.specialAbility(base);

        assertTrue(result >= base);
        
    }
}
