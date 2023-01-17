package level0;

public class level0_16 {

    //배열의 평균값
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;

        for (int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        answer = sum / numbers.length;

        return answer;
    }
}
