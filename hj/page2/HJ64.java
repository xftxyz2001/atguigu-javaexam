import java.util.Scanner;

public class HJ64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] list = new int[num];
        int pageStartIndex = 0;
        int pageIndex = 0;
        int pageEndIndex = list.length > 3 ? 3 : list.length - 1;

        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }

        String input = in.next();
        in.close();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'U') {
                if (pageIndex == 0) {
                    if (pageStartIndex == 0) { // 特殊上翻页
                        pageEndIndex = list.length - 1;
                        pageStartIndex = pageEndIndex - 3 >= 0 ? pageEndIndex - 3 : 0;
                        // pageIndex = 3;
                        pageIndex = list.length > 3 ? 3 : list.length - 1;
                    } else {
                        pageStartIndex--;
                        pageEndIndex--;
                    }
                } else {
                    pageIndex--;
                }
            } else {
                // if (pageIndex == 3) {
                // if (pageIndex == pageEndIndex) {
                if (pageIndex == (list.length > 3 ? 3 : list.length - 1)) {
                    if (pageEndIndex == list.length - 1) {
                        pageStartIndex = 0;
                        pageEndIndex = pageStartIndex + 3 < list.length ? pageStartIndex + 3 : list.length - 1;
                        pageIndex = 0;
                    } else {
                        pageStartIndex++;
                        pageEndIndex++;
                    }
                } else {
                    pageIndex++;
                }
            }
        }
        for (int i = pageStartIndex; i <= pageEndIndex; i++) {
            System.out.print(list[i]);
            if (i != pageEndIndex) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println(list[pageStartIndex + pageIndex]);
    }
}
