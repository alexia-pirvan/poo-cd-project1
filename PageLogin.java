import java.util.ArrayList;

public final class PageLogin extends Page {

    /**
     * Method where we verify if the user input
     * matches the existing data in the database.
     * Set page to AuthenticatedHome if positive,
     * return error and set to Unauthenticated if not.
     * @param task = our current action input
     */
    @Override
    public ActionOutput onPage(final ActionInput task) {
        if (task.getFeature().equals("login")) {
            String name = task.getCredentials().getName();
            String pass = task.getCredentials().getPassword();
            for (User u : Browser.getAllUsers()) {
                if (u.getCredentials().getName().equals(name)) {
                    if (u.getCredentials().getPassword().equals(pass)) {
                        Browser.setPage(new PageAuthenticatedHome());
                        Browser.setUser(u);
                        return new ActionOutput(null, new ArrayList<>(), u);
                    } else {
                        Browser.setPage(new PageUnauthenticatedHome());
                        return error(); //wrong password
                    }
                }
            }
        }
        Browser.setPage(new PageUnauthenticatedHome());
        return error(); //user/feature not found
    }

    @Override
    public ActionOutput changePage(final ActionInput task) {
        if (task.getPage().equals("register")) {
            Browser.setPage(new PageRegister());
            return null;
        }
        return error(); //another page
    }


}
