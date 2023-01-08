package 오큰수_17298;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //  Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
        // A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

        Stack<Integer> idxStack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];
        int[] answer = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        idxStack.push(0);
        for (int i = 1; i < n; i++) {
            while (!idxStack.isEmpty() && numArr[idxStack.peek()] < numArr[i]) {
                answer[idxStack.pop()] = numArr[i];
            }
            idxStack.push(i);
        }
        while (!idxStack.isEmpty()) {
            answer[idxStack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
