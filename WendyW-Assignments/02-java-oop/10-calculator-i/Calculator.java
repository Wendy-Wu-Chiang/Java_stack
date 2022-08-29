public class Calculator{
    private double operandOne;
    private char operation;
    private double operandTwo;
    private double result;

    //Will need a setOperandOne 
    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public Double getOperandOne() {
        return this.operandOne;
    }

    //Will need a setOperation that will add "+".
    public void setOperation(char operation) {
        this.operation = operation;
    }

    public char getOperation() {
        return this.operation;
    }

    // setOperandTwo 
    public void setOperandTwo(double operandTwo) {
        this.operandTwo=operandTwo;
    }

    public Double getOperandTwo() {
        return this.operandTwo;
    }
    
    //performOperation method that will execute calculation.
    public void performOperation() {
        if(this.operation == '+'){
            this.result = operandOne + operandTwo;
        }
        if(this.operation == '-'){
            this.result = operandOne - operandTwo;
        }    
    }    
        
    //need a getResult method to show result.
    public void getResult() {
        System.out.println(this.operandOne + " " + this.operation + " " + this.operandTwo + " = "  + this.result);
    }
}
