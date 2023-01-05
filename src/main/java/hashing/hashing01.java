package hashing;

import java.util.*;

 class hashing01 {


     public static int[] solution(String[] idList, String[] reportArr, int k){

         //answer배열
         // idList 만큼 만들어 줌.
        int[] answer = new int[idList.length];

         //1. Report 중복제거
         //한 사람이 다른 한 사람을 여러 번 신고할 수 없음.
         //중복제거를 위해 HashSet을 사용.
         HashSet<String> report = new HashSet<>(Arrays.asList(reportArr));
         System.out.println("1. Report 중복제거 : " + report);

         //1-1. reportHash 만들기
         // key: 신고한 사람 / value : 신고 당한 사람
         HashMap<String, HashSet<String>> reportHash = new HashMap<>();

         //1-2. stoped 만들기
         // key : 신고 당한 사람 / 신고 당한 횟수
         // ex : muzi : 1
         HashMap<String, Integer> stoped = new HashMap<>();


         //2.3. reportHash, stoped에 신고한 사람 이름 담기
         for (int i = 0; i < idList.length; i++){
             String name = idList[i];
             reportHash.put(name, new HashSet<>());
             stoped.put(name, i);
         }

         System.out.println("2. reportHash : " + reportHash);
         System.out.println("3. stoped : " + stoped);

        //4. report을 reportHash에 넣기
        // ex) muzi : seugi, youngju
        for(String x : report){
            String[] str = x.split(" ");

            String from = str[0]; //신고한 사람
            String to = str[1]; //신고 당한 사람
            reportHash.get(to).add(from);
        }
         System.out.println("4. reportHash : " + reportHash); // 신고 당한 사람 = [신고한 사람]

         for(int i = 0; i < idList.length; i++){
            HashSet<String> send = reportHash.get(idList[i]);
             System.out.println("send : " + send);
             //System.out.println("send.size() : " + send.size());
            if (send.size() >= k){
                for (String name : send){
                    System.out.println("stoped.get(name) : " + stoped.get(name));
                    answer[stoped.get(name)]++;
                }
            }
         }
         System.out.println("answer : " + Arrays.toString(answer));
         return answer;
     }

     public static void main(String[] args) {

         String[] idList = {"muzi", "frodo", "apeach", "neo"};
         String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
         int k = 2;
         solution(idList, report, 2);
     }

 }