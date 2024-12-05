package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.constants.Category;
import menu.domain.constants.Menu;

public class RecommendService {

    public List<Category> recommend(Coaches coaches) {
        List<Category> categories = recommendCategory();
        recommendMenuForEachCoach(coaches.getCoaches(), categories);
        return categories;
    }

    private void recommendMenuForEachCoach(List<Coach> coaches, List<Category> categories) {
        for (Category category : categories) {
            for (Coach coach : coaches) {
                recommendMenu(category, coach);
            }
        }
    }

    private void recommendMenu(Category category, Coach coach) {
        List<String> tempMenus = Menu.findByCategory(category);
        Menu menu;
        do {
            menu = Menu.from(Randoms.shuffle(tempMenus).get(0));
        } while (!coach.addEatMenu(menu));
    }

    private List<Category> recommendCategory() {
        List<Category> categories = new ArrayList<>();
        Map<Category, Integer> categoryMap = new HashMap<>();
        while (categories.size() < 5) {
            Category category = Category.from(Randoms.pickNumberInRange(1, 5));
            categoryMap.put(category, categoryMap.getOrDefault(category, 0) + 1);
            if (categoryMap.get(category) <= 2) {
                categories.add(category);
            }
        }
        return categories;
    }
}
