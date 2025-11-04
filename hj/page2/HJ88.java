import java.util.Scanner;

public class HJ88 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nextLine = in.nextLine();
        String[] split = nextLine.split("-");
        HandCard handCard0 = new HandCard(split[0].split(" "));
        HandCard handCard1 = new HandCard(split[1].split(" "));
        in.close();

        if (handCard0.type == HandCard.JOKERS) {
            System.out.println(split[0]);
        } else if (handCard1.type == HandCard.JOKERS) {
            System.out.println(split[1]);
        } else if (handCard0.type == HandCard.BOOM) {
            if (handCard1.type == HandCard.BOOM) {
                if (handCard0.cardsNum[0] > handCard1.cardsNum[0]) {
                    System.out.println(split[0]);
                } else {
                    System.out.println(split[1]);
                }
            } else {
                System.out.println(split[0]);
            }
        } else if (handCard1.type == HandCard.BOOM) {
            if (handCard0.type == HandCard.BOOM) {
                if (handCard0.cardsNum[0] > handCard1.cardsNum[0]) {
                    System.out.println(split[0]);
                } else {
                    System.out.println(split[1]);
                }
            } else {
                System.out.println(split[1]);
            }
        } else {
            if (handCard0.type != handCard1.type) {
                System.out.println("ERROR");
            } else {
                if (handCard0.cardsNum[0] > handCard1.cardsNum[0]) {
                    System.out.println(split[0]);
                } else {
                    System.out.println(split[1]);
                }
            }
        }

    }
}

class HandCard {

    public static final int JOKERS = 1;
    public static final int BOOM = 2;
    public static final int TRHEE = 3;
    public static final int SHUN = 4;
    public static final int DOUBLE = 5;
    public static final int ONE = 6;

    String[] cards;
    int[] cardsNum;
    int type;

    public HandCard(String[] cards) {
        this.cards = cards;
        this.cardsNum = new int[this.cards.length];
        for (int i = 0; i < cards.length; i++) {
            switch (cards[i]) {
                case "JOKER":
                    this.cardsNum[i] = 1000;
                    break;
                case "joker":
                    this.cardsNum[i] = 999;
                    break;
                case "2":
                    this.cardsNum[i] = 102;
                    break;
                case "A":
                    this.cardsNum[i] = 101;
                    break;
                case "K":
                    this.cardsNum[i] = 13;
                    break;
                case "Q":
                    this.cardsNum[i] = 12;
                    break;
                case "J":
                    this.cardsNum[i] = 11;
                    break;
                case "10":
                    this.cardsNum[i] = 10;
                    break;
                case "9":
                    this.cardsNum[i] = 9;
                    break;
                case "8":
                    this.cardsNum[i] = 8;
                    break;
                case "7":
                    this.cardsNum[i] = 7;
                    break;
                case "6":
                    this.cardsNum[i] = 6;
                    break;
                case "5":
                    this.cardsNum[i] = 5;
                    break;
                case "4":
                    this.cardsNum[i] = 4;
                    break;
                case "3":
                    this.cardsNum[i] = 3;
                    break;
                default:
                    this.cardsNum[i] = 0;
                    break;
            }
        }
        if (this.cards.length == 1) {
            this.type = ONE;
        } else if (this.cards.length == 2) {
            if (this.cardsNum[0] == 1000 || this.cardsNum[1] == 1000) {
                this.type = JOKERS;
            } else {
                this.type = DOUBLE;
            }
        } else if (this.cards.length == 3) {
            this.type = TRHEE;
        } else if (this.cards.length == 4) {
            this.type = BOOM;
        } else {
            this.type = SHUN;
        }
    }

}