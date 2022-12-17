import filters.Filter;

public final class ActionInput {
    private String type;
    private String page;
    private String feature;
    private UserAccount credentials;
    private String movie;
    private String startsWith;
    private Filter filters;
    private int count;
    private int rate;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(final String page) {
        this.page = page;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(final String feature) {
        this.feature = feature;
    }

    public UserAccount getCredentials() {
        return credentials;
    }

    public void setCredentials(final UserAccount credentials) {
        this.credentials = credentials;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(final String movie) {
        this.movie = movie;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }

    public Filter getFilters() {
        return filters;
    }

    public void setFilters(final Filter filters) {
        this.filters = filters;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }


    @Override
    public String toString() {
        return "ActionInput{"
                + "type='" + type + '\''
                + ", page='" + page + '\''
                + ", feature='" + feature + '\''
                + ", credentials=" + credentials + ", movie='" + movie + '\''
                + ", startsWith='" + startsWith + '\''
                + ", filters=" + filters + ", count=" + count + ", rate=" + rate
                + '}';
    }
}
