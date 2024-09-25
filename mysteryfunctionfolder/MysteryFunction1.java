package mysteryfunctionfolder;
import java.lang.Math;

public class MysteryFunction1 implements mysteryfunctionfolder.MysteryFunction{
    public MysteryFunction1(){}
    public double call(int n){
        return Math.pow(n, 2);
    }
}