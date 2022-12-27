package 구간_합_구하기_5_10999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] sumArr = new int[n + 1][n + 1];

        // 어차피 0으로 초기화되기는 하지만 명확한 게 좋아서 한 번 명시적으로 초기화
        for (int i = 0; i < n; i++) {
            sumArr[0][i] = 0;
            sumArr[i][0] = 0;
        }

        // 합 배열 만들기
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        // 구간 합 구하기 => D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
            System.out.println(sum);
        }
    }
}
