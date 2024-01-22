package jp.ac.uryukyu.ie.e235711;

public class Main {
    public static void main(String[] args) {
        // Startクラスの動作確認
        testStartClass();

        // ゲームフローの実行
        GameFlow gameFlow = new GameFlow();
        gameFlow.playGame();
    }

    // Startクラスの動作確認用メソッド
    private static void testStartClass() {
        Start start = new Start();
        int userInput = start.shouldStartGame();
        System.out.println("User input: " + userInput);
    }
}