package jp.ac.uryukyu.ie.e235711;

/**
 * ゲームを開始するためのメインクラス。
 */
public class Main {

    public static void main(String[] args) {
        Start start = new Start();
        if (start.shouldStartGame()) {
            GameFlow gameFlow = new GameFlow();
            gameFlow.playGame();
        } else {
            System.out.println("ゲームを中止しました。");
        }
    }
}
