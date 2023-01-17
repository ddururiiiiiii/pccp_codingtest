package level0;

public class level0_14 {

    //피자 나눠 먹기 (2)
    public int solution(int n) {
        int answer = 0;
        int pizzBox = 6;

        while(pizzBox % n != 0){
            pizzBox += 6;
        }

        answer = pizzBox / 6;

        return answer;
    }
}
