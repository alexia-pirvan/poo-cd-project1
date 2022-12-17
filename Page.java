import java.util.ArrayList;

public abstract class Page implements PageAction {
    /***/
    public abstract ActionOutput onPage(ActionInput task);
    /***/
    public abstract ActionOutput changePage(ActionInput task);

    /** Method which returns an error. */
    public final ActionOutput error() {
        return new ActionOutput("Error", new ArrayList<>(), null);
    }
}