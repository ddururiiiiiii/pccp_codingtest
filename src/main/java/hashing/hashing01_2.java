package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class hashing01_2 {


    public static int[] solution(String[] id_list, String[] reportArr, int k) {

        //answer 배열 만들기
        //길이 : id_list.length;
        int[] answer = new int[id_list.length];

        // report 중복제거
        HashSet<String> report = new HashSet<>(Arrays.asList(reportArr));
        System.out.println("1. reportArr 중복제거 : " + report);

        //map {신고 당한 사람 : 신고한 사람} Map 만들기
        Map<String, HashSet<String>> map = new HashMap<>();

        //신고 당한 사람 :신고 당한 횟수
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
        }
        System.out.println("빈 map = " + map);
        System.out.println("빈 idxMap : = " + idxMap);

        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }
        System.out.println("map : 신고당한사람-신고한사람 = " + map);

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
//            System.out.println("send = " + map.get(id_list[i]));
            if (send.size() >= k) {
                for (String name : send) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }


    public static void main(String[] args) {

        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        solution(idList, report, 2);
    }

}