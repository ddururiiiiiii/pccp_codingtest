package level0;

public class level0_7 {
    //분수의 덧셈

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        //분모
        int moNum = denom1 * denom2;

        //분자
        int jaNum = numer1 * denom2 + numer2 * denom1;

        //최소공배수
        int mixNum = 1;


        //약분
        for (int i = 1; i <= moNum; i++){
            if (moNum % i == 0 && jaNum % i == 0){
                mixNum = i;
            }
        }

        answer[0] = jaNum/mixNum;
        answer[1] = moNum/mixNum;

        return answer;
    }
}
