package level0;

import java.util.Arrays;

public class level0_10 {
    //중앙값 구하기
    public static int solution(int[] array) {
        int answer = 0;

        //오름차순 정렬하기
        Arrays.sort(array);

        //배열의 길이가 짝수일 경우
        if (array.length % 2 == 0){
            int index = array.length / 2;
            answer = array[index-1];
        } else {
            int index = array.length / 2;
            answer = array[index];
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 7, 10, 11};
        solution(array);
    }
}
