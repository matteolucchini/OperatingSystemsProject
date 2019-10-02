public class Buffer {
    private int[] sumSharedBuffer;
    private int[] diagonalSharedBuffer;

    public Buffer(int dim) {
        sumSharedBuffer = new int[dim];
        diagonalSharedBuffer = new int[dim];
    }

    public int[] getSumSharedBuffer() {
        return sumSharedBuffer;
    }

    public int[] getDiagonalSharedBuffer() {
        return diagonalSharedBuffer;
    }
}
