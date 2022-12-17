public final class PageMovies extends Page {
    @Override
    public ActionOutput onPage(final ActionInput task) {
        switch (task.getFeature()) {
            case "search" -> {
                Browser.searchMovies(task.getStartsWith());
                return new ActionOutput(null, Browser.getAvailableMovies(), Browser.getUser());
            }
            case "filter" -> {
                Browser.filterMovies(task.getFilters());
                return new ActionOutput(null, Browser.getAvailableMovies(), Browser.getUser());
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
                Browser.resetUserAvailableMovies();
                Browser.setPage(new PageAuthenticatedHome());
                return null;
            }
            case "see details" -> {
                PageSeeDetails pageSeeDetails = new PageSeeDetails(task.getMovie());
                if (pageSeeDetails.getMovie() != null) {
                    Browser.setUserAvailableMovie(pageSeeDetails.getMovie());
                    Browser.setPage(pageSeeDetails);
                    return new ActionOutput(null, Browser.getAvailableMovies(), Browser.getUser());
                } else {
                    Browser.resetUserAvailableMovies();
                    return error();
                }
            }
            case "movies" -> {
                Browser.resetUserAvailableMovies();
                return new ActionOutput(null, Browser.getNewAvailableMovies(), Browser.getUser());
            }
            default -> {
                Browser.resetUserAvailableMovies();
                return error();
            }
        }
    }

}
