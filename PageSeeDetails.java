public final class PageSeeDetails extends Page {
    private Movie movie;

    public PageSeeDetails(final String movie) {
        for (Movie m : Browser.getAvailableMovies()) {
            if (m.getName().equals(movie)) {
                this.movie = m;
            }
        }
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public ActionOutput onPage(final ActionInput task) {
        switch (task.getFeature()) {
            case "purchase" -> {
                if (Browser.getUser().getPurchasedMovies().contains(movie)) {
                    return error();
                } else if (Browser.getUser().getCredentials().getAccountType().equals("premium")
                            && Browser.getUser().getNumFreePremiumMovies() > 0) {
                    Browser.getUser().getPurchasedMovies().add(movie);
                    Browser.getUser().setNumFreePremiumMovies(Browser.getUser().getNumFreePremiumMovies() - 1);
                    Browser.getAllUsers().removeIf(u -> u.getCredentials().getName().equals(Browser.getUser().getCredentials().getName()));
                    Browser.getAllUsers().add(Browser.getUser());
                    return new ActionOutput(null, Browser.getAvailableMovies(), Browser.getUser());
                } else if (Browser.getUser().getTokensCount() > 2) {
                    Browser.getUser().setTokensCount(Browser.getUser().getTokensCount() - 2);
                    Browser.getUser().getPurchasedMovies().add(movie);
                    Browser.getAllUsers().removeIf(u -> u.getCredentials().getName().equals(Browser.getUser().getCredentials().getName()));
                    Browser.getAllUsers().add(Browser.getUser());
                    return new ActionOutput(null, Browser.getAvailableMovies(), Browser.getUser());
                } else {
                    return error();
                }
            }
            case "watch" -> {
                if (Browser.getUser().getPurchasedMovies().contains(movie)) {
                    Browser.getUser().getWatchedMovies().add(movie);
                    Browser.getAllUsers().removeIf(u -> u.getCredentials().getName().equals(Browser.getUser().getCredentials().getName()));
                    Browser.getAllUsers().add(Browser.getUser());
                    return new ActionOutput(null, Browser.getAvailableMovies(), Browser.getUser());
                } else {
                    return error();
                }
            }
            case "like" -> {
                if (Browser.getUser().getWatchedMovies().contains(movie)) {
                    Browser.getUser().getLikedMovies().add(movie);
                    for (Movie m : Browser.getAllMovies()) {
                        if (m.getName().equals(movie.getName())) {
                            m.setNumLikes(m.getNumLikes() + 1);
                        }
                    }
                    Browser.getAllUsers().removeIf(u -> u.getCredentials().getName().equals(Browser.getUser().getCredentials().getName()));
                    Browser.getAllUsers().add(Browser.getUser());
                    return new ActionOutput(null, Browser.getAvailableMovies(), Browser.getUser());
                } else {
                    return error();
                }
            }
            case "rate" -> {
                if (task.getRate() >= 1 && task.getRate() <= 5 && Browser.getUser().getWatchedMovies().contains(movie)) {
                    for (Movie m : Browser.getAllMovies()) {
                        if (m.getName().equals(movie.getName())) {
                            m.addRate(task.getRate());
                        }
                    }
                    Browser.getUser().getRatedMovies().add(movie);
                    Browser.getAllUsers().removeIf(u -> u.getCredentials().getName().equals(Browser.getUser().getCredentials().getName()));
                    Browser.getAllUsers().add(Browser.getUser());
                    return new ActionOutput(null, Browser.getAvailableMovies(), Browser.getUser());
                } else {
                    return error();
                }
            }
            default -> {
                return error();
            }
        }
    }

    @Override
    public ActionOutput changePage(final ActionInput task) {
        switch (task.getPage()) {
            case "logout" -> {
                Browser.setPage(new PageUnauthenticatedHome());
                Browser.setUser(null);
                return null;
            }
            case "home" -> {
                Browser.setPage(new PageAuthenticatedHome());
                return null;
            }
            case "movies" -> {
                Browser.setPage(new PageMovies());
                return new ActionOutput(null, Browser.getNewAvailableMovies(), Browser.getUser());
            }
            case "upgrades" -> {
                Browser.setPage(new PageUpgrades());
                return null;
            }
            default -> {
                return error();
            }
        }
    }
}
