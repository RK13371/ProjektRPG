public class Shop {

    public static void showShop(Player player) {
        boolean open = true;

        while(open) {
            UI.print("SKLEP:");
            UI.print("1. Mikstura leczenia - 40 złota:");
            UI.print("2. Mikstura siły - 30 złota:");
            UI.print("3. Mikstura szczęścia - 60 złota:");
            UI.print("4. Wyjście");

            int choice = UI.getInput(1, 4);

            switch(choice) {

                case 1:
                    int cost = 40;
                    if (player.getGold() < cost) {
                        System.out.println("Masz nie wystarczającą ilość złota");
                        break;
                    } else {
                        player.spendGold(cost);
                        player.useItem(new HealingPotion());
                        UI.print("Zakupiono miksturę leczenia");
                    }
                    break;

                case 2:
                    cost = 30;
                    if (player.getGold() < cost) {
                        System.out.println("Masz nie wystarczającą ilość złota");
                        break;
                    } else {
                        player.spendGold(cost);
                        player.useItem(new StrengthPotion());
                        UI.print("Zakupiono miksturę siły");
                    }
                    break;

                case 3:
                    cost = 60;
                    if (player.getGold() < cost) {
                        System.out.println("Masz nie wystarczającą ilość złota");
                        break;
                    } else {
                        player.spendGold(cost);
                        player.useItem(new LuckPotion());
                        UI.print("Zakupiono miksturę szczęścia");
                    }
                    break;

                case 4:
                    open = false;
                    break;
            }
        }
    }

}
