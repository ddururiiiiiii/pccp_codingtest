package level0;

public class level0_15 {

    //피자 나눠 먹기 (3)
    public int solution(int slice, int n) {
        int answer = 0;

        if (n % slice == 0){
            answer = n / slice;
        } else {
            answer = 1 + (n / slice);
        }


        return answer;
    }
}
