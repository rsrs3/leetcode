package DynamicProgramming;

/**
 * Created by rajat on 4/20/16.
 */
public class PaintFence {

    public int numWays(int n, int k) {
        if(n<2 || k==0) return n*k;
        int same = k, diff = k*(k-1);
        for(int i=2;i<n;++i){
            int temp = diff;
            diff = (same+diff)*(k-1);
            same=temp;
        }
        return same+diff;
    }

    public static void main(String[] args) {
        System.out.println(new PaintFence().numWays(6,2));
    }
}
