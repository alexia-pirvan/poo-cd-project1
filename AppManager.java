import java.util.ArrayList;

public final class AppManager {
    public static final int NUM_FREE_PREMIUM_MOVIES = 15;
    private final ArrayList<ActionInput> actions;
    private final ArrayList<ActionOutput> res;

    public AppManager(final InputData data) {
        Browser.setAllUsers(data.getUsers());
        Browser.setAllMovies(data.getMovies());
        Browser.setPage(new PageUnauthenticatedHome());
        actions = data.getActions();
        res = new ArrayList<>();
    }

    /** Method which computes all the input actions
     * and stores the result of running them in an
     * ActionOutput Array List, named res. The output
     * has to be different from null. */
    public void computeActions() {
        for (ActionInput action : actions) {
            ActionOutput aux = Browser.run(action);
            if (aux != null) {
                res.add(aux);
            }
        }
    }

    public ArrayList<ActionOutput> getRes() {
        return res;
    }

}
