import java.util.ArrayList;

public final class PageUnauthenticatedHome extends Page {

    @Override
    public ActionOutput onPage(final ActionInput task) {
        return new ActionOutput("Error", new ArrayList<>(), null);
    }

    @Override
    public ActionOutput changePage(final ActionInput task) {
        switch (task.getPage()) {
            case "login" -> Browser.setPage(new PageLogin());
            case "register" -> Browser.setPage(new PageRegister());
            default -> {
                return error();
            }
        }
        return null;
    }
}
