package menu.controller;

import java.util.List;
import menu.domain.Coaches;
import menu.domain.constants.Category;
import menu.exception.CustomException;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendService recommendService;

    public MenuController(final InputView inputView, final OutputView outputView, final RecommendService recommend) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.recommendService = recommend;
    }

    public void start() {
        outputView.printStartMenuRecommend();
        Coaches coaches = readCoaches();
        readCantEat(coaches);
        List<Category> categories = recommendService.recommend(coaches);
        outputView.printResult(coaches, categories);
    }

    private void readCantEat(Coaches coaches) {
        while (true) {
            try {
                inputView.readCantEat(coaches);
                break;
            } catch (CustomException customException) {
                outputView.printErrorMessage(customException.getMessage());
            }
        }
    }

    private Coaches readCoaches() {
        while (true) {
            try {
                return inputView.readCoachNames();
            } catch (CustomException customException) {
                outputView.printErrorMessage(customException.getMessage());
            }
        }
    }
}
