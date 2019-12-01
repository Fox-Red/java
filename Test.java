package TestCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    String rank;
    String color;

    public Card(String rank, String color) {
        this.rank = rank;
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" + rank + '\'' + color + '\'' + '}';
    }
}

public class Test {
    private static String[] color = {"♥", "♣" ,"♦" ,"♠"};

    //创建一张牌的方法
    private static List<Card> creatCardList() {
        List<Card> cardList = new ArrayList<>(52);

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cardList.add(new Card(""+i, color[j]));
            }
        }
        return cardList;
    }

    //洗牌的方法
    private static void washCard(List<Card> cardList) {
        Random random = new Random();
        for (int i = cardList.size() - 1; i > 0; i--) {
            int temp = random.nextInt(i);
            Card card = cardList.get(i);
            cardList.set(i, cardList.get(temp));
            cardList.set(temp, card);
        }
    }

    private static List<List<Card>> giveCard(List<Card> cardList, int playerNumber, int cardNumber) {
        List<List<Card>> playerCard = new ArrayList<>();
        for (int i = 0; i < playerNumber; i++) {
            playerCard.add(new ArrayList<>());
        }
        for (int i = 0; i < playerNumber; i++) {
            for (int j = 0; j < cardNumber; j++) {
                playerCard.get(i).add(cardList.remove(0));
            }
        }
        return playerCard;
    }

    public static void main(String[] args) {
        //需要一副牌
        List<Card> cardList = Test.creatCardList();
        System.out.println(cardList);
        //需要洗一下牌
        Test.washCard(cardList);
        System.out.println(cardList);
        //给玩家发牌
        List<List<Card>> oldCard = Test.giveCard(cardList, 4, 7);
        System.out.println(cardList);
        for (List<Card> val:
             oldCard) {
            System.out.println(val);
        }
    }
}
