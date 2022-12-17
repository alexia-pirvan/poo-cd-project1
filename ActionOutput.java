import java.util.ArrayList;

public final class ActionOutput {
    private String error;
    private ArrayList<Movie> currentMoviesList;
    private User currentUser;

    public ActionOutput(final String error,
                        final ArrayList<Movie> currentMoviesList, final User currentUser) {
        this.error = error;
        this.currentMoviesList = getDeepCopyMovies(currentMoviesList);
        if (currentUser == null) {
            this.currentUser = null;
        } else {
            this.currentUser = new User(currentUser);
        }
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public ArrayList<Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public ArrayList<Movie> getDeepCopyMovies(final ArrayList<Movie> movies) {
        ArrayList<Movie> list = new ArrayList<>();
        for (Movie m : movies) {
            list.add(new Movie(m));
        }
        return list;
    }

    public void setCurrentMoviesList(final ArrayList<Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public String toString() {
        return "ActionOutput{"
                + "error='" + error + '\''
                + ", currentMoviesList=" + currentMoviesList
                + ", currentUser=" + currentUser
                + '}';
    }
}
