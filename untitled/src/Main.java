import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // 测试用例数

        while (T-- > 0) {
            int m = in.nextInt(), n = in.nextInt();
            String[] A = new String[m];
            for (int i = 0; i < m; i++) {
                A[i] = in.next();
            }

            int p = in.nextInt(), q = in.nextInt();
            String[] B = new String[p];
            for (int i = 0; i < p; i++) {
                B[i] = in.next();
            }

            boolean found = false;
            // 遍历a中每个可能的起点
            for (int i = 0; i + p <= m && !found; i++) {
                for (int j = 0; j + q <= n && !found; j++) {
                    if (isSubMatrix(A, B, i, j, p, q)) {
                        found = true;
                    }
                }
            }

            System.out.println(found ? "Yes" : "No");
        }
    }

    // 判断从(a[i][j])开始的子矩阵是否等于B
    private static boolean isSubMatrix(String[] A, String[] B, int x, int y, int p, int q) {
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (A[x + i].charAt(y + j) != B[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}