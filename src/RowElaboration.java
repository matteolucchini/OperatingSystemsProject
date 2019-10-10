import java.util.concurrent.CountDownLatch;

/**
 * @author Matteo Lucchini
 */

public class RowElaboration extends Thread {
    private int[] row;
    private CountDownLatch latch;
    private Buffer sharedBuffer;
    private int i;

    /**
     *
     * @param row indicates the row I am considering
     * @param latch A synchronization aid that allows one or more threads to wait until
     *              a set of operations being performed in other threads completes
     * @param sharedBuffer buffer that contains partial results
     * @param i indicates the current value within a row
     */
    public RowElaboration(int[] row, CountDownLatch latch, Buffer sharedBuffer, int i) {
        super("Thread " + i);
        this.row = row;
        this.latch = latch;
        this.sharedBuffer = sharedBuffer;
        this.i = i;
    }

    @Override
    public void run() {
        /*
            this method will be called by the method .start()
            describes what the program does
        */
        sharedBuffer.getSumSharedBuffer()[i] = rowSum();
        sharedBuffer.getDiagonalSharedBuffer()[i] = row[i];
        latch.countDown();
    }

    /**
     *
     * @return total sum done row by row
     */
    private int rowSum() {
        int sum = 0;
        for(int i = 0; i < row.length; i++)
            sum += row[i];
        return sum;
    }




}
