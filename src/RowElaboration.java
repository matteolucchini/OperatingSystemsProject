import java.util.concurrent.CountDownLatch;

public class RowElaboration extends Thread {
    private int[] row;
    private CountDownLatch latch;
    private Buffer sharedBuffer;
    private int i;

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

    private int rowSum() {
        int sum = 0;
        for(int i = 0; i < row.length; i++)
            sum += row[i];
        return sum;
    }




}
