package jp.ac.uryukyu.ie.e235711;
import java.util.Scanner;

/**
 * ユーザーにゲームを開始するかどうかを尋ねるクラス。
 */
public class Start {

    /**
     * ユーザーにゲームを開始するかどうかを尋ね、適切な入力があるまで繰り返す。
     * @return ゲームを開始する場合は true、それ以外は false。
     */
    public boolean shouldStartGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ゲームを始めますか？（はい/いいえ）");
        String userInput = scanner.nextLine().toLowerCase();

        // はいまたはいいえ以外の入力があれば再度尋ねる
        while (!userInput.equals("はい") && !userInput.equals("いいえ")) {
            System.out.println("無効な入力です。'はい' または 'いいえ' を入力してください。");
            userInput = scanner.nextLine().toLowerCase();
        }
         // Scanner をクローズする
         scanner.close();
        return userInput.equals("はい");
    }
}
