public class Main {

    public static void main(String[] args) {


        Black black = new Black();
        black.createCards();
        System.out.println(black.stackOfCards);

        Player player1 = new Player("Nii", 1);
        Player player2 = new Player("NAA", 2);

        black.assignCards(player1, 1);
        black.assignCards(player2, 2);
        System.out.println();
        System.out.println(black.playersAndAssignedCards);
        //System.out.println(black.listOfAllCards);
        System.out.println();
        System.out.println(player2);

    }
}
