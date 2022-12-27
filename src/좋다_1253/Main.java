package 좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < n; i++) {
            long find = arr[i];
            int left = 0;
            int right = n - 1;

            while (left < right) {
                long tmpSum = arr[left] + arr[right];
                if (tmpSum == find) {
                    // 0, 5, -5 의 경우에
                    // 0 => 남은 두 개의 합
                    // 5 => 5 + 0
                    // -5 => -5 + 0 이런 식으로 자기 자신을 포함하게 됨
                    if (left != i && right != i) {
                        count++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else {
                        right--;
                    }
                } else if (tmpSum > find) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
