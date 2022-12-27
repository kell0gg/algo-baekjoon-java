package 숫자의_합_11720;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n은 실질적으로 안써도 됨
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String numbers = st.nextToken();
        int sum = 0;
        for (int i = 0; i < numbers.length(); i++) {
            sum += (numbers.charAt(i) - '0');
        }
        bw.write(String.format("%d\n",sum));
        bw.flush();
        bw.close();
    }
}
