import filters.Filter;

import java.util.ArrayList;

public final class Browser {
    private static Page page = new PageUnauthenticatedHome();
    private static ArrayList<User> allUsers;
    private static ArrayList<Movie> allMovies;
    private static User user = null;
    private static ArrayList<Movie> userAvailableMovies = new ArrayList<>();

    public Browser() {

    }

    public static ArrayList<Movie> getAllMovies() {
        return allMovies;
    }

    /***/
    public static ActionOutput run(final ActionInput task) {
        return switch (task.getType()) {
            case "on page" -> page.onPage(task);
            case "change page" -> page.changePage(task);
            default -> null;
        };
    }

    public static Page getPage() {
        return page;
    }

    public static void setPage(final Page page) {
        Browser.page = page;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(final ArrayList<User> allUsers) {
        Browser.allUsers = allUsers;
    }

    public static void setAllMovies(final ArrayList<Movie> allMovies) {
        Browser.allMovies = allMovies;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(final User user) {
        Browser.user = user;
        Browser.userAvailableMovies = new ArrayList<>();
    }

    /***/
    public static ArrayList<Movie> getNewAvailableMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (Movie m : allMovies) {
            if (!m.getCountriesBanned().contains(user.getCredentials().getCountry())) {
                movies.add(m);
            }
        }
        userAvailableMovies = movies;
        return new ArrayList<>(movies);
    }

    /***/
    public static void searchMovies(final String start) {
        getNewAvailableMovies();
        userAvailableMovies.removeIf(m -> !(m.getName().startsWith(start)));
    }

    /***/
    public static ArrayList<Movie> getAvailableMovies() {
        return userAvailableMovies;
    }

    /***/
    public static void filterMovies(final Filter filter) {
        getNewAvailableMovies();
        if (filter.getSort().getRating() != null) {
            userAvailableMovies.sort((m1, m2) -> {
                final double bigNumber = 100000.0;
                if (filter.getSort().getRating().equals("increasing")) {
                    return (int) (bigNumber * (m1.getRating() - m2.getRating()));
                } else {
                    return (int) -(bigNumber * (m1.getRating() - m2.getRating()));
                }
            });
        }
        if (filter.getSort().getDuration() != null) {
            userAvailableMovies.sort((m1, m2) -> {
                if (filter.getSort().getDuration().equals("increasing")) {
                    return m1.getDuration() - m2.getDuration();
                } else {
                    return m2.getDuration() - m1.getDuration();
                }
            });
        }
        if (filter.getContains().getActors() != null) {
            userAvailableMovies.removeIf(m
                    -> !(m.getActors().containsAll(filter.getContains().getActors())));
        }
        if (filter.getContains().getGenre() != null) {
            userAvailableMovies.removeIf(m
                    -> !(m.getGenres().containsAll(filter.getContains().getGenre())));
        }
    }


    public static void resetUserAvailableMovies() {
        getNewAvailableMovies();
    }

    public static void setUserAvailableMovie(final Movie movie) {
        Browser.userAvailableMovies = new ArrayList<>();
        Browser.userAvailableMovies.add(movie);
    }

}
