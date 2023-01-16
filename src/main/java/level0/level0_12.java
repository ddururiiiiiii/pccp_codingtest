package level0;

import java.util.HashMap;
import java.util.Map;

public class level0_12 {
    //짝수는 싫어요
    public static int[] solution(int n) {
        int[] answer = new int[(n+1)/2];

        for(int i = 0; i <= n; i++){
            if (i % 2 == 1){
                answer[i/2] = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        solution(12);
    }
}
