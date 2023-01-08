package 절댓값_힙_11286;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 절대값 우선순위 큐 사용
        // 0 이 주어지면 ? 가장 작은 값을 출력
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) {
                return a > b ? 1 : -1;
            } else {
                return absA - absB;
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if(pq.isEmpty()){
                    bw.write("0 \n");
                }
                else{
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(tmp);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
