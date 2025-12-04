public class AutoSaveThread extends Thread {

    private final Player player;
    private boolean isRunning = true;

    public AutoSaveThread(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        System.out.println("AUTOSAVE start [DEBUG]");

        while(isRunning) {
            try {
                System.out.println("AUTOSAVE sleep [DEBUG]");
                Thread.sleep(10000);
                System.out.println("AUTOSAVE start again [DEBUG]");
            } catch (InterruptedException e) {
                return;
            }

            if(player.isAlive()) {
                System.out.println("AUTOSAVE attempt [DEBUG]");
                SaveManager.saveGame(player, player.getRound(), false);
                player.setAutosaved(true);
            }

        }
    }

    public void stopAutosave() {
        isRunning = false;
    }

}
