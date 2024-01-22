package jp.ac.uryukyu.ie.e235711;

import java.util.Scanner;

public class Start {
    private Scanner scanner;

    public Start() {
        this.scanner = new Scanner(System.in);
    }

    public int shouldStartGame() {
        System.out.println("ゲームを始めますか？（はい:1/いいえ:2）");

        int userInput = scanner.nextInt();

        while (userInput != 1 && userInput != 2) {
            System.out.println("無効な入力です。1（はい） または 2（いいえ） を入力してください。");
            userInput = scanner.nextInt();
        }

        return userInput;
    }
    
    public void closeScanner() {
        scanner.close();
    }
}
