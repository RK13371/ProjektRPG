public class LuckPotion extends Item {

    public LuckPotion() {
        super("Mikstura szczęścia");
    }

    @Override
    public void itemEffect(Player player) {
        player.setAttackCount(3);
    }

}
