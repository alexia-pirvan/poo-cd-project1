public final class PageUpgrades extends Page {
    private static final int PREMIUM_ACCOUNT_PRICE = 10;

    @Override
    public ActionOutput onPage(final ActionInput task) {
        switch (task.getFeature()) {
            case "buy premium account" -> {
                int balance = Browser.getUser().getTokensCount();
                if (balance >= PREMIUM_ACCOUNT_PRICE) {
                    Browser.getUser().setTokensCount(balance - PREMIUM_ACCOUNT_PRICE);
                } else {
                    return error();
                }
                Browser.getUser().getCredentials().setAccountType("premium");
                return null;
            }
            case "buy tokens" -> {
                int count = task.getCount();
                int balance = Integer.parseInt(Browser.getUser().getCredentials().getBalance());
                if (balance < count) {
                    return error();
                }
                Browser.getUser().setTokensCount(Browser.getUser().getTokensCount() + count);
                Browser.getUser().getCredentials().setBalance(Integer.toString(balance - count));
                return null;
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
            case "movies" -> {
                Browser.setPage(new PageMovies());
                return new ActionOutput(null, Browser.getNewAvailableMovies(), Browser.getUser());
            }
            case "home" -> {
                Browser.setPage(new PageAuthenticatedHome());
                return null;
            }
            default -> {
                return error();
            }
        }
    }
}
