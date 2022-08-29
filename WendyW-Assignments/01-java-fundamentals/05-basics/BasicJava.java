import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {	
	
    public static void OneTo255() {
		for(int i = 0; i <= 255; i++)
			System.out.println(i);
	}
	
	public static void PrintOdds() {
		for(int i = 0; i <= 255; i++) {
			if(i % 2 == 1){
				System.out.println(i);
            }
		}
	}
    public static int GetArraySum(int[] num1) {
        int sum = 0;
        for(int i = 0; i < num1.length; i++) {
            sum += num1[i];
        }
        System.out.println(sum);
        return sum;
    }
    public static int PrintSum() {
        int sum = 0;
        for(int i = 0; i <= 255; i++) {
            sum += i;
            System.out.println(String.format("New number: %d, Sum: %d", i, sum));
        }
        return sum;
    }
    public static void ArrayIterate(int[] num1) {
        for(int val: num1) {
            System.out.println(val);
        }
    }
    public static int Maximum(int[] num1) {
        int max = num1[0];
        for(int i = 0; i < num1.length; i++) {
            if(max < num1[i]) {
                max = num1[i];
            }
        }
        System.out.println("Max: " + max);
        return max;
    }
    public static double GetAvg(int[] num1) {
        int sum = 0;
        for(int i = 0; i < num1.length; i++) {
            sum += num1[i];
        }
        double avg = sum/num1.length;
        System.out.println("Average: "+ avg);
        return avg;

    }
    public static ArrayList<Integer> OddArray() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 0; i < 256; i++) {
            if(i % 2 == 1){
            y.add(i);
            }
        }
        System.out.println(y);
        return y;
    }
    public static int GreaterThanY(int[] num1, int y) {
        int count = 0;
        for(int i = 0; i < num1.length; i++){
            if(num1[i] > y) {
                count ++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void ValSquare(int[] num1){
        for(int i = 0; i < num1.length; i++) {
            num1[i] = num1[i]*num1[i];
            System.out.println(num1[i]);
        }
    }

    public static void MaxMinAvg(int[] num2){
        int max = num2[0];
        int min = num2[0];
        int sum = 0;
        for(int i = 0; i < num2.length; i++){
            if(num2[i] > max){
                max = num2[i];
            }
            if(num2[i] < min) {
                min = num2[i];
            }
            sum += num2[i];
        }
        int avg = sum/num2.length;
        int[] newArr = {max,min,avg};
        System.out.println(Arrays.toString(newArr));

    }

    public static void ShiftingValues(int[] nums3){
        for(int i = 1; i < nums3.length; i++){
            nums3[i-1] = nums3[i];
        }
        nums3[nums3.length-1] = 0;
        System.out.println(Arrays.toString(nums3));
    }
}