package menu;

import menu.controller.MenuController;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MenuController menuController = new MenuController(new InputView(), new OutputView(), new RecommendService());
        menuController.start();
    }
}
