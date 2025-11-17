public class L415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int c = 0;
        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int sum = n1 + n2 + c;
            sb.append(sum % 10);
            c = sum / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int n1 = num1.charAt(i) - '0';
            int sum = n1 + c;
            sb.append(sum % 10);
            c = sum / 10;
            i--;
        }
        while (j >= 0) {
            int n2 = num2.charAt(j) - '0';
            int sum = n2 + c;
            sb.append(sum % 10);
            c = sum / 10;
            j--;
        }
        if (c != 0) {
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();

    }
}
