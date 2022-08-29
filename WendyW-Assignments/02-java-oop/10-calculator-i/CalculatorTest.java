public class CalculatorTest{
    public static void main(String[] args) {
        Calculator a = new Calculator();
        a.setOperandOne(7.5);
        a.setOperation('+');
        a.setOperandTwo(8.2);
        a.performOperation();
        a.getResult();
    }
}

//A client of yours requires a basic calculator for their application. 
// They need a way to run a series of operations and save the result.
//  They only need adding and subtracting functionality right now. 
// They need the method performOperation and getResults to be the methods that run all the operations and return the end result respectively.

// ● setOperandOne(10.5)

// ● setOperation("+")

// ● setOperandTwo(5.2)

// ● performOperation()

// ● getResults()

// where the result would be 15.7.