public class Main {

    public static void main(String[] args) {


        Black black = new Black();
        black.createCards();

//        black.assignCards(player1, 1);
//        black.assignCards(player2, 2);
//        System.out.println();
//        System.out.println(player2);
//        System.out.println(player2.getPlayerCards());

        black.startGame();

    }
}
