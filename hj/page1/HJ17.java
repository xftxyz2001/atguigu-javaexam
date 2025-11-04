import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        String[] splited = line.split(";");
        int x = 0;
        int y = 0;
        for (String cmd : splited) {
            if (cmd.length() < 2) {
                continue;
            }
            try {
                char op = cmd.charAt(0);
                int arg = Integer.parseInt(cmd.substring(1, cmd.length()));
                if (arg > 0 && arg < 100) {
                    switch (op) {
                        case 'A':
                            x -= arg;
                            break;
                        case 'D':
                            x += arg;
                            break;
                        case 'W':
                            y += arg;
                            break;
                        case 'S':
                            y -= arg;
                            break;

                        default:
                            break;
                    }
                }
            } catch (Exception e) {
            }

        }
        System.out.println(x + "," + y);
    }
}
