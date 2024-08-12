package baseball.service;

public class BaseballService {
    public boolean validRestart(int param) {
        if (param == 1) {
            return true;
        }
        if (param == 2) {
            return false;
        }
        throw new IllegalArgumentException("유효하지 않는 값입니다.");
    }
    public boolean validateInputNumber(int inputNumber) {
        if (inputNumber == 1 || inputNumber == 2) {
            return false;
        }
        System.out.printf("%d은 옳지않은 입력값입니다.\n", inputNumber);
        return true;
    }
}
