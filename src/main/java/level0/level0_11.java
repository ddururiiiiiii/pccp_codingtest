package level0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class level0_11 {
    //최빈값 구하기
    public static int solution(int[] array) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < array.length; i++){
           map.put(array[i], 0);
        }
        System.out.println("map = " + map);

        for (int i = 0; i < array.length; i++){

        }
        return answer;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 3, 3, 4};
        solution(array);
    }
}
