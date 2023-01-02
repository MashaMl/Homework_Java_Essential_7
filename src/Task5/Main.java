package Task5;

import java.util.Scanner;

class Calculator {
    public void add(double firstNum, double secondNum) {
        System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
    }
    public void sub(double firstNum, double secondNum) {
        System.out.println(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
    }
    public void mul(double firstNum, double secondNum) {
        System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
    }
    public void dev(double firstNum, double secondNum) {
        try{
            if(secondNum == 0) throw new Exception("Try to divide by zero");
            System.out.println(firstNum + " / " + secondNum + " = " + (firstNum / secondNum));
        }catch (Exception e) {
            System.out.println("Exception Handling");
            System.out.println(e.getMessage());
        }

    }
}

public class Main{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double firstNum = scanner.nextDouble();
        System.out.println("Enter second number: ");
        double secondNum = scanner.nextDouble();
        System.out.println("Choose the operation: \n+ - type 1\n- - type 2\n* - type 3\n/ - type 4");
        int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                calculator.add(firstNum, secondNum);
                break;
            case 2:
                calculator.sub(firstNum, secondNum);
                break;
            case 3:
                calculator.mul(firstNum, secondNum);
                break;
            case 4:
                calculator.dev(firstNum, secondNum);
                break;
            default:
                System.out.println("Wrong operation");
        }

    }
}
