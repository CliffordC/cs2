/**
 * The interface for the link cells in a doubly linked list
 */
public interface IDLink<N> {
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public N getValue();

    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(N v);

    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public IDLink<N> getNext();

    /**
     * Gets the previous cell in the list
     * @return the cell
     */
    public IDLink<N> getPrev();

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(IDLink<N> c);

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setPrev(IDLink<N> c);
}
