import java.util.Scanner;

public class calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void calculate() {
        double num1 = getDouble1();
        char operation = getOperation();
        double num2 = getDouble2();
        double result = calc(num1,num2,operation);
        System.out.println("Siri: "+"Результат операции: "+result);
    }

    public static double getDouble1(){
        System.out.println("Введите первое число:");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getDouble1();
        }
        return num;
    }

    public static double getDouble2(){
        System.out.println("Введите второе число:");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getDouble2();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введите операцию(+,-,*,/):");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double num1, double num2, char operation){
        double result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
}