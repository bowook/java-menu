package menu.domain.constants;

import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPANESE_FOOD(1, "일식"),
    KOREAN_FOOD(2, "한식"),
    CHINESE_FOOD(3, "중식"),
    ASIAN_FOOD(4, "아시안"),
    WESTERN_FOOD(5, "양식");

    private final int number;
    private final String name;

    Category(final int number, final String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category from(int randomNumber) {
        return Arrays.stream(Category.values())
                .filter(category -> category.number == randomNumber)
                .findFirst()
                .orElseThrow();
    }

    public static String result(List<Category> categories) {
        StringBuilder categoryBuilder = new StringBuilder();
        categoryBuilder.append("[ 카테고리 | ");
        for (Category category : categories) {
            categoryBuilder.append(category.getName()).append(" | ");
        }
        categoryBuilder.setLength(categoryBuilder.length() - 3);
        categoryBuilder.append(" ]");
        return categoryBuilder.toString();
    }
}
