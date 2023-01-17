package level0;

public class level0_13 {

    //피자 나눠 먹기 (1)
    public int solution(int n) {
        int answer = 0;

        if (n / 7 > 0){
            if (n % 7 == 0){
                answer = n / 7;
            } else {
                answer = n / 7 + 1;
            }
        } else {
            answer = 1;
        }
        return answer;
    }
}
