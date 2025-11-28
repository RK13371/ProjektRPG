public class HealingPotion extends Item{

    public HealingPotion() {
        super("Mikstura leczenia");
    }

    @Override
    public void itemEffect(Player player) {
        player.setHealth(player.getHealth() + 40);
    }
}
