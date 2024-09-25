package mysteryfunctionfolder;
public class MysteryFunction2 implements mysteryfunctionfolder.MysteryFunction{
    public MysteryFunction2(){}
    public double call(int n){
        return Math.pow(n,3) + Math.sin(n);
    }
}