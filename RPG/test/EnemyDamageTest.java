import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EnemyDamageTest {

    @Test
    public void testEnemyDamage() {
        Enemy enemy = new Enemy(EnemyType.GOBLIN, 1);

        int baseDamage=  EnemyType.GOBLIN.getDamage();

        for(int i = 0; i < 50; i++) {
            int dmg = enemy.getDamageValue();
            assertTrue(dmg >= baseDamage - 5);
            assertTrue(dmg <= baseDamage + 5);
        }
    }
}
