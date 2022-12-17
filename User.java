import java.util.ArrayList;

public final class User {
    private UserAccount credentials;
    private int tokensCount;
    private int numFreePremiumMovies = AppManager.NUM_FREE_PREMIUM_MOVIES;
    private ArrayList<Movie> purchasedMovies = new ArrayList<>();
    private ArrayList<Movie> watchedMovies = new ArrayList<>();
    private ArrayList<Movie> likedMovies = new ArrayList<>();
    private ArrayList<Movie> ratedMovies = new ArrayList<>();

    public User() {

    }

    public User(User u) {
        this.credentials = new UserAccount(u.getCredentials());
        this.tokensCount = u.getTokensCount();
        this.numFreePremiumMovies = u.getNumFreePremiumMovies();
        this.purchasedMovies = getDeepCopyMovies(u.getPurchasedMovies());
        this.watchedMovies = getDeepCopyMovies(u.getWatchedMovies());
        this.likedMovies = getDeepCopyMovies(u.getLikedMovies());
        this.ratedMovies = getDeepCopyMovies(u.getRatedMovies());
    }

    public ArrayList<Movie> getDeepCopyMovies(final ArrayList<Movie> movies) {
        ArrayList<Movie> list = new ArrayList<>();
        for (Movie m : movies) {
            list.add(new Movie(m));
        }
        return list;
    }

    public User(final UserAccount credentials) {
        this.credentials = new UserAccount(credentials);
        if (credentials.getAccountType().equals("premium")) {
            this.numFreePremiumMovies = AppManager.NUM_FREE_PREMIUM_MOVIES;
        }
    }

    public UserAccount getCredentials() {
        return credentials;
    }

    public void setCredentials(final UserAccount credentials) {
        this.credentials = credentials;
    }

    public int getTokensCount() {
        return tokensCount;
    }

    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    /***/
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    public void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    @Override
    public String toString() {
        return "User{"
                + "credentials=" + credentials
                + ", tokensCount=" + tokensCount
                + ", numFreePremiumMovies=" + numFreePremiumMovies
                + ", purchasedMovies=" + purchasedMovies
                + ", watchedMovies=" + watchedMovies
                + ", likedMovies=" + likedMovies
                + ", ratedMovies=" + ratedMovies
                + '}';
    }
}
