package menu.exception;

public enum ErrorMessage {
    COACH_NAME_LENGTH_ERROR("코치의 이름은 최소 2글자, 최대 4글자 입니다."),
    COACH_COUNTS_ERROR("코치는 최소 2명, 최대 5명 입니다."),
    COACH_NOT_EAT("못먹는 메뉴는 최대 2개까지 입력할 수 있습니다."),
    NO_MENU("해당 메뉴는 없는 메뉴 입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}