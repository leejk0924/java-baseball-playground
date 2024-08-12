package baseball;

import baseball.controller.BaseballController;

public class Application {
    private static final BaseballController baseballController = new BaseballController();
    private static boolean EXECUTE = true;

    public static void main(String[] args) {
        while (EXECUTE) {
            EXECUTE = baseballController.restart();
        }
    }
}
