package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class hashing01_3 {


    public static int[] solution(String[] idList, String[] reportArr, int k){

        //answer 배열 만들기
        // lengh -> idList
        int [] answer = new int[idList.length];

        //answer 배열
        //reportArr 중복 제거
        //한 사람이 같은 사람 중복 신고 불가능.
        HashSet<String> report = new HashSet<>(Arrays.asList(reportArr));
        System.out.println("1. reportArr 중복제거 : " + report);




        return answer;
    }

    public static void main(String[] args) {

        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        solution(idList, report, 2);
    }

}