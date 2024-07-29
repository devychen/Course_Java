/**
 * @author Mackenzie
 */

public class StairsLoop {
    public static void main(String[] args) {
        int n = 4; // 阶梯的层数
        printStairs(n);
    }

    public static void printStairs(int n) {
        // 行数为2 * n - 1 (每层的顶部和底部)
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i % 2 == 0) {
                // 打印空格和 "+"
                for (int j = 0; j < n - 1 - i / 2; j++) {
                    System.out.print("    ");
                }
                for (int j = 0; j <= i / 2; j++) {
                    System.out.print("+---");
                }
                System.out.println("+");
            } else {
                // 打印空格和 "|"
                for (int j = 0; j < n - 1 - i / 2; j++) {
                    System.out.print("    ");
                }
                for (int j = 0; j <= i / 2; j++) {
                    System.out.print("|   ");
                }
                System.out.println("|");
            }
        }
    }
}
