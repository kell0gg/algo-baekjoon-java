package DNA_비밀번호_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] map = new int[4];
        int[] minCount = new int[4];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        st = new StringTokenizer(br.readLine());

        minCount[0] = Integer.parseInt(st.nextToken());
        minCount[1] = Integer.parseInt(st.nextToken());
        minCount[2] = Integer.parseInt(st.nextToken());
        minCount[3] = Integer.parseInt(st.nextToken());


        int left = 0;
        int right = m - 1;
        int count = 0;

        for (int i = 0; i < m; i++) {
            map[convertDnaToNumber(dna.charAt(i))]++;
        }

        while (right < dna.length()) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (map[i] < minCount[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
            map[convertDnaToNumber(dna.charAt(left))]--;
            left++;
            right++;
            if (right < dna.length()) {
                map[convertDnaToNumber(dna.charAt(right))]++;
            }
        }

        System.out.println(count);
    }

    private static int convertDnaToNumber(char c) {
        if (c == 'A') {
            return 0;
        }
        if (c == 'C') {
            return 1;
        }
        if (c == 'G') {
            return 2;
        }
        if (c == 'T') {
            return 3;
        }
        return -1;
    }
}
