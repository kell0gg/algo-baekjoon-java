package 수들의_합_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // left 를 옮기면 총 합이 작아진다.
        // right 를 옮기면 총 합이 커진다.
        int left = 1;
        int right = 1;
        int count = 0;
        int sum = 1;
        while (right <= n) {
            if (sum == n) {
                count++;
                right++;
                sum += right;
            } else if (sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        System.out.println(count);
    }
}
