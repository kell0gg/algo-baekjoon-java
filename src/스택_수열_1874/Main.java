package 스택_수열_1874;

import java.io.*;
import java.util.Stack;

public class Main {
    /*
    0. 스택에 넣을 값을 가지고 있는 자연수
    1. 현재 수열의 위치를 가지고 있는 index 1개
    2. 스택에서 값을 제거할 때 현재 수열하고 값이 맞지 않다면 => NO
    3. 현재 수열과 동일한 값이 될 때까지 스택에 0에서 정의한 자연수를 넣음
     */
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int currentNumber = 1;
        int[] sequenceArray = new int[n];
        for (int i = 0; i < n; i++) {
            sequenceArray[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < sequenceArray.length; i++) {
            int target = sequenceArray[i];
            if (target >= currentNumber) {
                while (target >= currentNumber) {
                    stack.push(currentNumber++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int tmp = stack.pop();
                if (tmp == target) {
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(sb.toString());
        }
        br.close();
    }
}
