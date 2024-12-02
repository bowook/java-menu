package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.constants.Category;
import menu.domain.constants.Day;

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
            System.out.println(coach.toString());
        }
        System.out.println();
        System.out.println(SUCCESS_RECOMMEND);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
