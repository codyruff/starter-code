package mysteryfunctionfolder;
public class main{

    public static int largestN(int k, mysteryfunctionfolder.MysteryFunction f){
        /*
         * Returns the largest integer value of N such that f.call(N) < k
         */
        int n = 0;
        while(f.call(n) < k){
            n++;
        }
        return n-1;
    }

    public static void main(String[] args){
        System.out.println("Testing on MysteryFunction1:");
        mysteryfunctionfolder.MysteryFunction1 f = new mysteryfunctionfolder.MysteryFunction1();
        int k = 27;
        int n = largestN(k, f);
        System.out.println("Output: " + n);

        System.out.println("Testing on MysteryFunction3:");
        mysteryfunctionfolder.MysteryFunction3 g = new mysteryfunctionfolder.MysteryFunction3();
        int k_3 = 10000;
        int n_3 = largestN(k_3, g);
        System.out.println("Output: " + n_3);
    }
}