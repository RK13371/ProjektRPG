public class AutoSaveThread extends Thread {

    private final Player player;
    private boolean isRunning = true;

    public AutoSaveThread(Player player) {
        this.player = player;
    }

    @Override
    public void run() {

        while(isRunning) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                return;
            }

            if(player.isAlive()) {
                SaveManager.saveGame(player, player.getRound(), false);
                player.setAutosaved(true);
            }

        }
    }

    public void stopAutosave() {
        isRunning = false;
    }

}
