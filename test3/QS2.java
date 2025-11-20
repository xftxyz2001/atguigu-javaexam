import java.util.LinkedList;

public class QS2 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            if ("+".equals(token) ||
                    "-".equals(token) ||
                    "*".equals(token) ||
                    "/".equals(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;

                    default:
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
