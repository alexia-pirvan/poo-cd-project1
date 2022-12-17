public interface PageAction {
    /** Method in which we execute an action on page
     * based on the input task.
     * @param task = the action input to execute
     */
    ActionOutput onPage(ActionInput task);

    /** Method with the help of which we change
     * to a different page based on the input task.
     * @param task = the action input that triggers
     *             a change in page
     */
    ActionOutput changePage(ActionInput task);
}
