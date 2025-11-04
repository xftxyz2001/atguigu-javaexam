public class StrTest {
    public static int[] nextArray(char[] charArray) {
        int[] next = new int[charArray.length];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && charArray[i] != charArray[j]) {
                j = next[j - 1];
            }
            if (charArray[i] == charArray[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int strStr(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int[] next = nextArray(charArray2);

        int i = 0, j = 0;
        while (i < charArray1.length && j < charArray2.length) {
            if (charArray1[i] == charArray2[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }
        return j == charArray2.length ? charArray1.length - charArray2.length : -1;
    }

    public static void main(String[] args) {

        int i = strStr("aabaabaaf", "aabaaf");
        System.out.println(i);
    }
}
