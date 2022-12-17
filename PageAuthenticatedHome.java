public final class PageAuthenticatedHome extends Page {
    @Override
    public ActionOutput onPage(final ActionInput task) {
        return error();
    }

    @Override
    public ActionOutput changePage(final ActionInput task) {
        switch (task.getPage()) {
            case "logout" -> {
                Browser.setPage(new PageUnauthenticatedHome());
                Browser.setUser(null);
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
