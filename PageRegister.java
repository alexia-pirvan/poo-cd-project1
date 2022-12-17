import java.util.ArrayList;

public final class PageRegister extends Page {

    @Override
    public ActionOutput onPage(final ActionInput task) {
        if (task.getFeature().equals("register")) {
           String name = task.getCredentials().getName();
            for (User u : Browser.getAllUsers()) {
                if (u.getCredentials().getName().equals(name)) {
                    Browser.setPage(new PageUnauthenticatedHome());
                    return error(); //user already exists
                }
            }
            User user = new User(task.getCredentials());
            Browser.getAllUsers().add(user);
            Browser.setPage(new PageAuthenticatedHome());
            Browser.setUser(user);
            return new ActionOutput(null, new ArrayList<>(), user);
        }
        Browser.setPage(new PageUnauthenticatedHome());
        return error();
    }

    @Override
    public ActionOutput changePage(final ActionInput task) {
        if (task.getPage().equals("login")) {
            Browser.setPage(new PageLogin());
            return null;
        }
        return error();
    }
}
