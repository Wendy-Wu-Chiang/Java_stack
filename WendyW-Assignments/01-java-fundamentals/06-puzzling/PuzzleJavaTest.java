import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class PuzzleJavaTest{
    public static void main(String[] args){
        int[] num = {3,5,1,2,7,9,8,13,25,32};
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int lowerbound = 54;
        int upperbound = 100;
        
        PuzzleJava.SumGreater(num);
        ArrayList<String> GetNames = new ArrayList<>(Arrays.asList ("Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"));
        PuzzleJava.PrintNames(GetNames);
        PuzzleJava.GetAlphabet();
        PuzzleJava.GetRandomNum(lowerbound, upperbound);
        PuzzleJava.RandomString(alphabet);
        PuzzleJava.GetRandomString();
    }
}
