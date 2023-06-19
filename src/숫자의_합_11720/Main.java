package 숫자의_합_11720;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n 을 입력받지만 따로 사용할 필요가 없음
        st.nextToken();

        // 숫자를 입력받음
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        String numbers = st.nextToken();
        for (int i = 0; i < numbers.length(); i++) {
            sum += (numbers.charAt(i) - '0');
        }
        bw.write(String.format("%d\n", sum));
        br.close();
        bw.close();
    }
}
