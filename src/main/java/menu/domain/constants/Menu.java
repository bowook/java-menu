package menu.domain.constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public enum Menu {
    GYUDON(Category.JAPANESE_FOOD, "규동"),
    UDON(Category.JAPANESE_FOOD, "우동"),
    MISO_SOUP(Category.JAPANESE_FOOD, "미소시루"),
    SUSHI(Category.JAPANESE_FOOD, "스시"),
    ONIGIRI(Category.JAPANESE_FOOD, "오니기리"),
    HAYASHI_RICE(Category.JAPANESE_FOOD, "하이라이스"),
    RAMEN(Category.JAPANESE_FOOD, "라멘"),
    OKONOMIYAKI(Category.JAPANESE_FOOD, "오꼬노미야끼"),
    GIMBAP(Category.KOREAN_FOOD, "김밥"),
    KIMCHI_STEW(Category.KOREAN_FOOD, "김치찌개"),
    SSAMBAP(Category.KOREAN_FOOD, "쌈밥"),
    DOENJANG_STEW(Category.KOREAN_FOOD, "된장찌개"),
    BIBIMBAP(Category.KOREAN_FOOD, "비빔밥"),
    KALGUKSU(Category.KOREAN_FOOD, "칼국수"),
    BULGOGI(Category.KOREAN_FOOD, "불고기"),
    TTEOKBOKKI(Category.KOREAN_FOOD, "떡볶이"),
    JEYUK_BOKKEUM(Category.KOREAN_FOOD, "제육볶음"),
    GANPUNGGI(Category.CHINESE_FOOD, "깐풍기"),
    FRIED_NOODLES(Category.CHINESE_FOOD, "볶음면"),
    DONGPO_PORK(Category.CHINESE_FOOD, "동파육"),
    JAJANGMYEON(Category.CHINESE_FOOD, "짜장면"),
    JJAMPPONG(Category.CHINESE_FOOD, "짬뽕"),
    MAPO_TOFU(Category.CHINESE_FOOD, "마파두부"),
    SWEET_AND_SOUR_PORK(Category.CHINESE_FOOD, "탕수육"),
    TOMATO_AND_EGG_STIR_FRY(Category.CHINESE_FOOD, "토마토 달걀볶음"),
    CHILI_PEPPER_AND_MEAT_STIR_FRY(Category.CHINESE_FOOD, "고추잡채"),
    PAD_THAI(Category.ASIAN_FOOD, "팟타이"),
    KHAO_PAD(Category.ASIAN_FOOD, "카오 팟"),
    NASI_GORENG(Category.ASIAN_FOOD, "나시고렝"),
    PINEAPPLE_FRIED_RICE(Category.ASIAN_FOOD, "파인애플 볶음밥"),
    PHO(Category.ASIAN_FOOD, "쌀국수"),
    TOM_YUM_GOONG(Category.ASIAN_FOOD, "똠얌꿍"),
    BANHMI(Category.ASIAN_FOOD, "반미"),
    SPRING_ROLLS(Category.ASIAN_FOOD, "월남쌈"),
    BUN_CHA(Category.ASIAN_FOOD, "분짜"),
    LASAGNA(Category.WESTERN_FOOD, "리자냐"),
    GRATIN(Category.WESTERN_FOOD, "그라탱"),
    GNOCCHI(Category.WESTERN_FOOD, "뇨끼"),
    QUICHE(Category.WESTERN_FOOD, "끼슈"),
    FRENCH_TOAST(Category.WESTERN_FOOD, "프렌치 토스트"),
    BAGUETTE(Category.WESTERN_FOOD, "바게트"),
    SPAGHETTI(Category.WESTERN_FOOD, "스파게티"),
    PIZZA(Category.WESTERN_FOOD, "피자"),
    PANINI(Category.WESTERN_FOOD, "파니니");

    private final Category category;
    private final String name;

    Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> findByCategory(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.category == category)
                .map(Menu::getName)
                .collect(Collectors.toList());
    }


    public static Menu from(String input) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(input))
                .findAny()
                .orElseThrow(() -> CustomException.from(ErrorMessage.NO_MENU));
    }
}
