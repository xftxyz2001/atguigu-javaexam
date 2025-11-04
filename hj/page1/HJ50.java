import java.util.LinkedList;
import java.util.Scanner;

public class HJ50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> opStack = new LinkedList<>();
        char[] charArray = line.toCharArray();
        boolean numFlag = false;

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i]) || (!numFlag && charArray[i] == '-')) {
                numFlag = true;
                int flag = 1;
                if (charArray[i] == '-') {
                    flag = -1;
                    i++;
                }
                int num = charArray[i] - '0';
                for (i++; i < charArray.length; i++) {
                    if (!Character.isDigit(charArray[i])) {
                        i--;
                        break;
                    }
                    num = num * 10 + (charArray[i] - '0');
                }
                numStack.push(num * flag);
            } else { // 运算符
                numFlag = false;
                char op2 = charArray[i];
                if (op2 == '(' || op2 == '[' || op2 == '{') {
                    opStack.push(op2);
                } else if (op2 == ')' || op2 == ']' || op2 == '}') {
                    numFlag = true;
                    while (!opStack.isEmpty()) {
                        char op1 = opStack.pop();
                        if ((op1 == '(' || op1 == '[' || op1 == '{')) {
                            break;
                        }
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        numStack.push(exec(num1, num2, op1));
                    }
                } else if (op2 == '+' || op2 == '-') {
                    if (opStack.isEmpty()) {
                        opStack.push(op2);
                    } else {
                        while (!opStack.isEmpty()) {
                            char op1 = opStack.pop();
                            if ((op1 == '(' || op1 == '[' || op1 == '{')) {
                                opStack.push(op1);
                                break;
                            }
                            int num2 = numStack.pop();
                            int num1 = numStack.pop();
                            numStack.push(exec(num1, num2, op1));
                        }
                        opStack.push(op2);
                    }
                } else if (op2 == '*' || op2 == '/') {
                    if (opStack.isEmpty()) {
                        opStack.push(op2);
                    } else {
                        while (!opStack.isEmpty()) {
                            char op1 = opStack.pop();
                            if ((op1 == '(' || op1 == '[' || op1 == '{') || (op1 == '+' || op1 == '-')) {
                                opStack.push(op1);
                                break;
                            }
                            int num2 = numStack.pop();
                            int num1 = numStack.pop();
                            numStack.push(exec(num1, num2, op1));
                        }
                        opStack.push(op2);
                    }

                }
            }
        }
        while (!opStack.isEmpty()) {
            char op1 = opStack.pop();
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            numStack.push(exec(num1, num2, op1));
        }
        System.out.println(numStack.pop());
    }

    private static int exec(int num1, int num2, char op1) {
        // System.out.println(num1 + " " + op1 + " " + num2);
        switch (op1) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

}
