package menu.view;

import java.util.Scanner;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.utils.Parser;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final static String INPUT_CANT_EAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public void readCantEat(Coaches coaches) {
        System.out.println();
        for (Coach coach : coaches.getCoaches()) {
            System.out.printf(INPUT_CANT_EAT + System.lineSeparator(), coach.getName());
            coach.addCantEatMenu(Parser.nameToMenu(readConsole()));
            System.out.println();
        }
    }

    public Coaches readCoachNames() {
        System.out.println(INPUT_COACH_NAME);
        return Parser.nameToCoach(readConsole());
    }

    private String readConsole() {
        return scanner.nextLine();
    }

    public void closeConsole() {
        scanner.close();
    }
}
