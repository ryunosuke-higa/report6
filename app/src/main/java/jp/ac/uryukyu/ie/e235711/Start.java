package jp.ac.uryukyu.ie.e235711;

import java.util.Scanner;

/**
 * ゲームを始めるかどうかを決定するクラス
 */
public class Start {
    private Scanner scanner;

    public Start() {
        this.scanner = new Scanner(System.in);
    }

 /**
     * ゲームを始めるかどうかのユーザーの入力を取得するメソッド
     * @return ユーザーの入力（はい: 1 / いいえ: 2）
     */

    public int shouldStartGame() {
        System.out.println("ゲームを始めますか？（はい:1/いいえ:2）");

        int userInput = scanner.nextInt();

        while (userInput != 1 && userInput != 2) {
            System.out.println("無効な入力です。1（はい） または 2（いいえ） を入力してください。");
            userInput = scanner.nextInt();
        }

        return userInput;
    }
     /**
     * Scannerを閉じるメソッド
     */
    public void closeScanner() {
        scanner.close();
    }
}
