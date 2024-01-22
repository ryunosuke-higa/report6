package jp.ac.uryukyu.ie.e235711;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * ゲームの進行を管理するクラス。
 */
public class GameFlow {
    private List<Integer> player1Hand;
    private List<Integer> player2Hand;
    private List<Integer> pointCards;
    private int player1Points;
    private int player2Points;

/**
 * ゲームの初期状態の設定
 */

    public GameFlow() {
        player1Hand = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        player2Hand = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        pointCards = new ArrayList<>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        player1Points = 0;
        player2Points = 0;
    }

    /**
     *ゲームを実行するメソッド
    */
   public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!pointCards.isEmpty() && !player1Hand.isEmpty() && !player2Hand.isEmpty()) {
            // ポイントカードを表示
            int currentPointCard = drawRandomCard(pointCards);
            System.out.println("ポイントカード: " + currentPointCard);

            // プレイヤーがカードを選択
            int player1Choice = selectCardFromHand(player1Hand, scanner);
            int player2Choice = selectRandomCard(player2Hand);

            // プレイヤーとコンピュータのカードを比較し、結果を表示
            System.out.println("Player 1 のカード: " + player1Choice);
            System.out.println("Player 2 のカード: " + player2Choice);
            compareCards(player1Choice, player2Choice);

            // ポイントを計算
            player1Hand.remove(Integer.valueOf(player1Choice));
            player2Hand.remove(Integer.valueOf(player2Choice));
            pointCards.remove(Integer.valueOf(currentPointCard));

            // 現在の獲得ポイントと獲得合計ポイントを表示
            System.out.println("Player 1 の現在の獲得ポイント: " + player1Points);
            System.out.println("Player 2 の現在の獲得ポイント: " + player2Points);
        }

        // 最終結果を表示
        displayResults();
    }

    private void compareCards(int playerCard, int computerCard) {
        if (playerCard > computerCard) {
            System.out.println("Player 1 が勝ちました！");
            player1Points += playerCard;
        } else if (playerCard < computerCard) {
            System.out.println("Player 2 が勝ちました！");
            player2Points += computerCard;
        } else {
            System.out.println("引き分けです！");
        }
    }


    private int selectCardFromHand(List<Integer> hand, Scanner scanner) {
        if (hand.isEmpty()) {
            return 0; 
        }

        System.out.println("あなたの手札: " + hand);
        System.out.println("手札からカードを選んでください：");
        int userInput = scanner.nextInt();

        while (!hand.contains(userInput)) {
            System.out.println("無効な入力です。手札からカードを選んでください。");
            userInput = scanner.nextInt();
        }

        return userInput;
    }

    private void displayResults() {
        System.out.println("Player 1 のポイント: " + player1Points);
        System.out.println("Player 2 のポイント: " + player2Points);

        if (player1Points > player2Points) {
            System.out.println("Player 1 の勝利！");
        } else if (player1Points < player2Points) {
            System.out.println("Player 2 の勝利！");
        } else {
            System.out.println("引き分けです！");
        }
    }

    private int drawRandomCard(List<Integer> cards) {
        Random random = new Random();
        int index = random.nextInt(cards.size());
        return cards.get(index);
    }

    private int selectRandomCard(List<Integer> hand) {
        if (hand.isEmpty()) {
            return 0; 
        }

        Random random = new Random();
        int index = random.nextInt(hand.size());
        return hand.get(index);
    }
}