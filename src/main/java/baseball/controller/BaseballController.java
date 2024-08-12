package baseball.controller;

import baseball.service.BaseballService;

import java.util.Scanner;

public class BaseballController {
    private BaseballService baseballService = new BaseballService();
    public boolean restart() {
        int inputNumber = 0;
        boolean flag = true;
        while(flag){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            inputNumber = scanner.nextInt();
            flag = baseballService.validateInputNumber(inputNumber);
        }
        return baseballService.validRestart(inputNumber);
    }
}
