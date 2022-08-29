public class BasicJavaTest {
    public static void main(String[] args){
        int[] num1 = {1,3,5,7,9,13};
        int[] num2 = {1,5,10,-2};
        int[] num3 = {1,5,10,7,-2};
        int y = 7;
        BasicJava.OneTo255();
        BasicJava.PrintOdds();
        BasicJava.GetArraySum(num1);
        BasicJava.PrintSum();
        BasicJava.ArrayIterate(num1);
        BasicJava.Maximum(num1);
        BasicJava.GetAvg(num1);
        BasicJava.OddArray();
        BasicJava.GreaterThanY(num1,y);
        BasicJava.ValSquare(num1);
        BasicJava.MaxMinAvg(num2);
        BasicJava.ShiftingValues(num3);
    }
}