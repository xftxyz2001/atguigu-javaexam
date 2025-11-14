public class T10 {
    public static void main(String[] args) {
        String str = "11111222223";
        int k = 3;
        while (str.length() > k) {
            StringBuilder sb = new StringBuilder();
            int n = 0;
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
                n++;
                if (n == k) {
                    sb.append(sum);
                    n = 0;
                    sum = 0;
                }
            }
            if (n != 0) {
                sb.append(sum);
            }
            str = sb.toString();
        }
        System.out.println(str);
    }
}
