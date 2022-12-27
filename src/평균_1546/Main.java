package 평균_1546;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double sum = 0;
        double max = 0;
        for (int i = 0; i < n; i++) {
            double score = Double.parseDouble(st.nextToken());
            if (score > max) max = score;
            sum += score;
        }

        // ((a + b + c) / m) * 100 / n
        bw.write(String.format("%f\n", ((sum / max) * 100.0) / n));
        bw.flush();
        br.close();
        bw.close();
    }
}
