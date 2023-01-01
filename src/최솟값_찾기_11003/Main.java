package 최솟값_찾기_11003;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new ArrayDeque<>(n);

        for (int i = 0; i < n; i++) {
            int currentValue = Integer.parseInt(st.nextToken());

            // 매번 정렬하지 않고 값을 넣을 때 자기보다 큰 수는 제거함
            while (!deque.isEmpty() && deque.getLast().value > currentValue) {
                deque.pollLast();
            }

            deque.addLast(new Node(i, currentValue));

            // 한 칸씩 이동하면서 범위를 지난 값은 제거함
            if (deque.getFirst().idx == (i - m)) {
                deque.pollFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Node {
    public int idx;
    public int value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}
