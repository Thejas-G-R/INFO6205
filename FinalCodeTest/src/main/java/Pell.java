public class Pell {
    public Pell() {
    }

    public long get(int n) {
        if (n < 0) throw new UnsupportedOperationException("Pell.get is not supported for negative n");
        else if (n == 0 || n == 1 || n==2) {
            return n;
        } else {
            long lower = 1l;
            long higher = 2l;
            long result = 0l;
            long count = 2;
            while (count < n) {
                result = 2 * higher + lower;
                lower = higher;
                higher = result;
                ++count;
            }
            return result;
        }
    }


}
