import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pailie {

    // public static int pailie(Map<Character, Integer> map) {
    // Set<Character> keySet = map.keySet();
    // int diffElemNum = keySet.size();
    // if (diffElemNum == 1) {
    // return 1;
    // }
    // int total = 0;
    // for (char c : keySet) {
    // int count = map.get(c);
    // if (count > 0) {
    // map.put(c, count - 1);
    // if (count - 1 == 0) {
    // map.remove(c);
    // }
    // total += pailie(new HashMap<>(map));
    // map.put(c, count);
    // }
    // }
    // return total;
    // }

    // public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    // String input = scanner.nextLine();
    // scanner.close();

    // char[] charArray = input.toCharArray();
    // Map<Character, Integer> hash = new HashMap<>();
    // for (char c : charArray) {
    // hash.put(c, hash.getOrDefault(c, 0) + 1);
    // }

    // System.out.println(pailie(hash));
    // }

    public static int getPermutationCount(char[] arr) {
        int n = arr.length;
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : arr) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        int numerator = getFactorial(n);
        int denominator = getRepeatedCharactersFactorial(countMap);
        return numerator / denominator;
    }

    private static int getFactorial(int n) {
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static int getRepeatedCharactersFactorial(Map<Character, Integer> map) {
        int factorial = 1;
        for (int count : map.values()) {
            if (count > 1) {
                factorial *= getFactorial(count);
            }
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int permutationCount = getPermutationCount(input.toCharArray());
        System.out.println(permutationCount);
    }
}
