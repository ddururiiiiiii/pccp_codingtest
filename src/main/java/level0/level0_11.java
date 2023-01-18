package level0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class level0_11 {
    //최빈값 구하기
    public static int solution(int[] array) {

        int maxCount = 0;
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            System.out.println("count = " + count);
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else  if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 3, 3, 4};
        solution(array);
    }
}
