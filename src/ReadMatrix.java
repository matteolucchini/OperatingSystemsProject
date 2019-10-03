import java.util.concurrent.CountDownLatch;

public class ReadMatrix extends AbstractReadMatrix {
    private RowElaboration[] rows;
    private CountDownLatch latch;
    private Buffer b;

    public ReadMatrix(int mat[][]) {
        this.mat = mat;
        init();
    }

    protected void init() {
        rows = new RowElaboration[mat.length];
        latch = new CountDownLatch(mat.length);
        b = new Buffer(mat.length);
        for(int i = 0; i < mat.length; i++) {
            rows[i] = new RowElaboration(mat[i], latch, b, i);
        }
    }
    
    public void startElaboration() {
        try {
            for(RowElaboration row : rows)
                row.start();
            latch.await();
            int tot = totSum();
            int totDiag = totDiagSum();
            System.out.println("Random matrix is:\n");
            for(int i = 0; i < mat.length; i++) {
                System.out.print("| ");
                for (int y = 0; y < mat[i].length; y++) {
                    System.out.print(mat[i][y] + " ");
                    if (y == mat.length - 1) {
                        System.out.print("|\n");
                    }
                }
            }
            System.out.println("__________________________\n");
            for(int i = 0; i < rows.length; i++)
                System.out.println("Sum row " + (i + 1) + " = " + b.getSumSharedBuffer()[i]);
            System.out.println("Diagonal is: ");
            for(int i = 0; i < mat.length; i++)
                System.out.print(mat[i][i] + " ");
            System.out.println();
            System.out.println("__________________________\n");
            System.out.println("Total rows sum = " + tot);
            System.out.println("Total diagonal sum = " + totDiag);
            System.out.println("__________________________\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected int totSum() {
        int tot = 0;
        for(int n : b.getSumSharedBuffer())
            tot += n;
        return tot;
    }

    protected int totDiagSum() {
        int tot = 0;
        for(int n : b.getDiagonalSharedBuffer())
            tot += n;
        return tot;
    }
}
