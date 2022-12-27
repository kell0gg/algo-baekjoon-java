package 나머지_합_10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 합 배열 구하기
        long[] sumArr = new long[n + 1];
        sumArr[0] = 0;
        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i - 1] + Long.parseLong(st.nextToken());
        }

        long count = 0;

        // m 으로 나눈 나머지를 담기 위한 배열
        long[] map = new long[m];
        for (int i = 1; i <= n; i++) {
            int remainder = (int) (sumArr[i] % m);
            if (remainder == 0) count++;
            map[remainder]++;
        }

        // if s[i] % m == s[j] % m then (s[i] - s[j]) % m == 0
        for (int i = 0; i < m; i++) {
            if (map[i] >= 2) {
                count = count + (map[i] * (map[i] - 1) / 2);
            }
        }

        System.out.println(count);
        br.close();
    }
}
