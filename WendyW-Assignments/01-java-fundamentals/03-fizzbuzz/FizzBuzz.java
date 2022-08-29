public class FizzBuzz {
  public String fizzBuzz(int value) {
    if (value % 3 == 0 && value % 5 == 0) {
      return "FizzBuzz";
    } else if (value % 3 == 0) {
      return "Fizz";
    } else if (value % 5 == 0) {
      return "Buzz";
    } else {
      return Integer.toString(value);
    }
  }


  public void counter() {
    for(int i = 1; i <= 100; i++){
      String result = fizzBuzz(i);
      System.out.println("Number: " + i + "-" + "Result: " + result);
    }
  }
}