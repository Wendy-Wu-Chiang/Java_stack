import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class PuzzleJava{

    public static ArrayList<Integer> SumGreater(int[] num){
        int sum = 0;
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for(int i = 0; i < num.length; i++){
            sum += num[i];
            if(num[i] > 10){
                myArray.add(num[i]);
            }
        }
        System.out.println(sum); //  Print the sum 
        System.out.println(myArray); //numbers greater than 10
        return myArray;
    }
    public static void PrintNames(ArrayList<String> name){
        Collections.shuffle(name);
        System.out.println(name);//print the name
        for(int i = 0; i < name.size(); i++) {
            String c = name.get(i);
            if(c.length() > 5) {
                System.out.println(c);//names that are longer than 5 characters.
            }
        }
    }
    public static void GetAlphabet() {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }
        System.out.println(alphabet);// 26 letters of the alphabet
        Collections.shuffle(alphabet);//Shuffle the array
        System.out.println(alphabet.get(25)); //Pulls the last character in the array.
        System.out.println(alphabet.get(0)); //Pulls the first character in the array.
            if(alphabet.get(0) == 'a') {
                System.out.println("You Got VOWELED!");
            }
            if(alphabet.get(0) == 'e') {
                System.out.println("You Got VOWELED!");
            }
            if(alphabet.get(0) == 'i') {
                System.out.println("You Got VOWELED!");
            }
            if(alphabet.get(0) == 'o') {
                System.out.println("You Got VOWELED!");
            }
            if(alphabet.get(0) == 'u') {
                System.out.println("You Got VOWELED!");
            }// If the first letter in the array is a vowel, have it display a message.
    }
    private static int getMax(int[] arr) {
        return 0;
    }
    private static int getMin(int[] arr) {
        return 0;
    }
    public static int[] GetRandomNum(int lowerbound, int upperbound) {
        int[] arr = new int[10];
        int offset = upperbound - lowerbound;
        Random r = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(offset) + lowerbound; 
            System.out.println(arr[i]);// random numbers in the 55-99.
        }
        Arrays.sort(arr);
        int max = getMax(arr);
        System.out.println("Max: " + arr[9]);// maximum value
        int min = getMin(arr);
        System.out.println("Min: " + arr[0]);//minimum value
        return arr;// Display all the numbers in the array
    }
    public static String RandomString(String chars) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println(randomString);
        return randomString;//Create a random string that is 5 characters long.
    }

    public static ArrayList<String> GetRandomString() {
        ArrayList<String> random = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            random.add(RandomString(null)); //Calls on previous method.
        }
        return random;//Generate an array with 10 random strings that are each 5 characters long
    }
}