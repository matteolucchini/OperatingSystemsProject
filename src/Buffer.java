/**
 * @author Matteo Lucchini
 */

public class Buffer {
    private int[] sumSharedBuffer;
    private int[] diagonalSharedBuffer;

    /**
     * Allows to create a new shared buffer of the specified size
     * @param dim buffer size
     */
    public Buffer(int dim) {
        sumSharedBuffer = new int[dim];
        diagonalSharedBuffer = new int[dim];
    }

    /**
     *
     * @return shared buffer that can be shared with all threads
     * containing the sum of each row
     */
    public int[] getSumSharedBuffer() {
        return sumSharedBuffer;
    }

    /**
     *
     * @return shared buffer that can be shared with all threads
     * containint the elements on the diagonal
     */
    public int[] getDiagonalSharedBuffer() {
        return diagonalSharedBuffer;
    }
}
