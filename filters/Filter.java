package filters;

public final class Filter {
    private SortFilter sort = new SortFilter();
    private ContainsFilter contains = new ContainsFilter();

    public SortFilter getSort() {
        return sort;
    }

    public void setSort(final SortFilter sort) {
        this.sort = sort;
    }

    public ContainsFilter getContains() {
        return contains;
    }

    public void setContains(final ContainsFilter contains) {
        this.contains = contains;
    }
}
