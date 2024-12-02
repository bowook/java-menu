package menu.utils;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.constants.Menu;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public class Parser {
    private final static String COMMA = ",";
    private final static int MIN = 2;
    private final static int MAX = 5;

    public static Coaches nameToCoach(String coachNames) {
        Coaches coaches = new Coaches();
        List<String> prevCoaches = List.of(coachNames.split(COMMA));
        checkCoachCounts(prevCoaches);
        for (String coach : prevCoaches) {
            coaches.addCoach(new Coach(coach));
        }
        return coaches;
    }

    public static List<Menu> nameToMenu(String menuNames) {
        List<Menu> menus = new ArrayList<>();
        List<String> prevMenus = List.of(menuNames.split(COMMA));
        for (String prevMenu : prevMenus) {
            menus.add(Menu.from(prevMenu));
        }
        return menus;
    }

    private static void checkCoachCounts(List<String> prevCoaches) {
        if (prevCoaches.size() < MIN || prevCoaches.size() > MAX) {
            throw CustomException.from(ErrorMessage.COACH_COUNTS_ERROR);
        }
    }
}
