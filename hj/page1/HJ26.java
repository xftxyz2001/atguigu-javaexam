
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HJ26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        ArrayList<Character> characters = new ArrayList<>(line.length());
        for (int i = 0; i < line.length(); i++) {
            characters.add(line.charAt(i));
        }
        List<Character> sortedCharacters = characters.stream().filter(Character::isAlphabetic)
                .sorted((ch1, ch2) -> Character.toUpperCase(ch1) - Character.toUpperCase(ch2))
                .collect(Collectors.toList());

        int index = 0;
        for (Character character : characters) {
            if (!Character.isAlphabetic(character)) {
                System.out.print(character);
            } else {
                System.out.print(sortedCharacters.get(index++));
            }
        }

    }
}
