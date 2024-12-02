package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.domain.constants.Menu;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public class Coach {
    private final List<Menu> eatMenus = new ArrayList<>();
    private final List<Menu> cantEatMenus = new ArrayList<>();
    private final String name;

    public Coach(final String name) {
        validate(name);
        this.name = name;
    }

    public boolean addEatMenu(Menu menu) {
        if (!cantEatMenus.contains(menu)) {
            eatMenus.add(menu);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder menuBuilder = new StringBuilder();
        menuBuilder.append("[ ").append(name);
        for (Menu menu : eatMenus) {
            menuBuilder.append(" | ");
            menuBuilder.append(menu.getName());
        }
        menuBuilder.append(" ]");
        return menuBuilder.toString();
    }

    public void addCantEatMenu(List<Menu> menus) {
        cantEatMenus.addAll(menus);
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw CustomException.from(ErrorMessage.COACH_NAME_LENGTH_ERROR);
        }
    }
}
