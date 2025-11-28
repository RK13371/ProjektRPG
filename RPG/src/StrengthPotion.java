public class StrengthPotion extends Item{

    public StrengthPotion() {
        super("Mikstura siły");
    }

    @Override
    public void itemEffect(Player player) {
        player.setDamage(player.getDamage()+15);
    }

}
