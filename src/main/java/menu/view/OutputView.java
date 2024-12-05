package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.constants.Category;
import menu.domain.constants.Day;
import menu.domain.constants.Menu;

public class OutputView {
    private final static String START_MENU_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    private final static String RESULT_MENU_RECOMMEND = "메뉴 추천 결과입니다.";
    private final static String SUCCESS_RECOMMEND = "추천을 완료했습니다.";

    public void printStartMenuRecommend() {
        System.out.println(START_MENU_RECOMMEND);
        System.out.println();
    }

    public void printResult(Coaches coaches, List<Category> categories) {
        System.out.println(RESULT_MENU_RECOMMEND);
        System.out.println(Day.result());
        System.out.println(Category.result(categories));
        for (Coach coach : coaches.getCoaches()) {
            printMenu(coach);
        }
        System.out.println();
        System.out.print(SUCCESS_RECOMMEND);
    }

    private void printMenu(Coach coach) {
        List<Menu> menus = coach.getEatMenus();
        System.out.printf("[ %s | %s | %s | %s | %s | %s ]%n", coach.getName(), menus.get(0).getName(),
                menus.get(1).getName(), menus.get(2).getName(), menus.get(3).getName(), menus.get(4).getName());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
