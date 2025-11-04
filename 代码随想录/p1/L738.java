public class L738 {
    public static void main(String[] args) {
        System.out.println(new L738().monotoneIncreasingDigits(10));
    }

    public int monotoneIncreasingDigits(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int start = charArray.length;
        for (int i = charArray.length - 2; i >= 0; i--) {
            if (charArray[i] > charArray[i + 1]) {
                charArray[i]--;
                start = i + 1; // 9
            }
        }
        for (int i = start; i < charArray.length; i++) {
            charArray[i] = '9';
        }
        return Integer.parseInt(new String(charArray));
    }
}
