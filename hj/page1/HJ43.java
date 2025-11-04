import java.util.LinkedList;
import java.util.Scanner;

class HJ43Point {
    int x;
    int y;

    public HJ43Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class HJ43 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt(); // 行数
        int w = in.nextInt(); // 列数
        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        int[][] vis = new int[h][w];
        vis[0][0] = 1;
        LinkedList<HJ43Point> path = new LinkedList<>();
        path.push(new HJ43Point(0, 0));
        dfs(arr, vis, path);
    }

    private static void dfs(int[][] arr, int[][] vis, LinkedList<HJ43Point> path) {
        HJ43Point p0 = path.peek();
        if (p0.x == arr.length - 1 && p0.y == arr[0].length - 1) {
            printPath(path);
            System.exit(0);
        }
        if (p0.x > 0 && arr[p0.x - 1][p0.y] == 0 && vis[p0.x - 1][p0.y] == 0) {
            vis[p0.x - 1][p0.y] = 1;
            path.push(new HJ43Point(p0.x - 1, p0.y));
            dfs(arr, vis, path);
            path.pop();
        }
        if (p0.y > 0 && arr[p0.x][p0.y - 1] == 0 && vis[p0.x][p0.y - 1] == 0) {
            vis[p0.x][p0.y - 1] = 1;
            path.push(new HJ43Point(p0.x, p0.y - 1));
            dfs(arr, vis, path);
            path.pop();
        }
        if (p0.x < arr.length - 1 && arr[p0.x + 1][p0.y] == 0 && vis[p0.x + 1][p0.y] == 0) {
            vis[p0.x + 1][p0.y] = 1;
            path.push(new HJ43Point(p0.x + 1, p0.y));
            dfs(arr, vis, path);
            path.pop();
        }
        if (p0.y < arr[0].length - 1 && arr[p0.x][p0.y + 1] == 0 && vis[p0.x][p0.y + 1] == 0) {
            vis[p0.x][p0.y + 1] = 1;
            path.push(new HJ43Point(p0.x, p0.y + 1));
            dfs(arr, vis, path);
            path.pop();
        }
    }

    private static void printPath(LinkedList<HJ43Point> path) {
        while (!path.isEmpty()) {
            HJ43Point p = path.pop();
            printPath(path);
            System.out.println(p);
        }
    }
}
