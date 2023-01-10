package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class Array02 {

    public static int[] solution(int[] fees, String[] records) {

        //inTime
        //들어 온 시간을 넣는다.
        int[] inTime = new int[10000];

        //isIn
        //현재 들어온 상태인지 나간 상태인지 넣는다.
        int[] inIn = new int[10000];

        //sumT
        //누적된 주차시간을 넣는다.
        int[] sumT = new int[10000];

        //차량의 댓수
        //중복 허용 안하려고 hashSet썼다.
        HashSet<String> carSet = new HashSet<>();

        for (String record : records) {
            String[] str = record.split(" ");
//            str[0]; //입차시간
//            str[1]; //차번호
//            str[2]; //in or out
            carSet.add(str[1]);

            //입차인 경우
            if (str[2].equals("IN")) {

                //시간을 분으로 환산한다.
                String[] str2 = str[0].split(":");
                int inMin = (Integer.parseInt(str2[0]) * 60) + Integer.parseInt(str2[1]);

                //inTime에 환산한 분을 넣는다.
                inTime[Integer.parseInt(str[1])] = inMin;

                //입차 상태를 등록한다.
                inIn[Integer.parseInt(str[1])] = 1;

            } else if (str[2].equals("OUT")) {

                //시간을 분으로 환산한다.
                String[] str2 = str[0].split(":");
                int outMin = (Integer.parseInt(str2[0]) * 60) + Integer.parseInt(str2[1]);

                //inTime 입차시간 - 출차시간 계산한다.
                int sumMin = outMin - inTime[Integer.parseInt(str[1])];

                //누적시간을 sumT에 넣는다.
                sumT[Integer.parseInt(str[1])] += sumMin;

                //출차 상태를 등록한다.
                inIn[Integer.parseInt(str[1])] = 0;

            }
        }

            //출차 안한 차량의 누적 주차시간 계산하여 넣어준다.
            for (int inIns : inIn) {
                if (inIns == 1) {
                    sumT[inIns] += (23 * 60 + 59) - inTime[inIns];
                }
            }

            int[] answer = new int[carSet.size()];
            
            //주차비 계산하기
            for (int sumTs : sumT) {
                if (sumTs > 0) {
                    for (int i = 0; i < answer.length; i++) {
//                        5000 + ⌈(334 - 180) / 10⌉ x 600 = 14600
                        answer[i] = (fees[1]+(int)Math.ceil((double)(sumTs - fees[0])/fees[2])*fees[3]);
                    }
                }
            }
        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }



    public static void main(String[] args) {

        // 기본시간, 기본요금, 단위시간, 단위요금
        int[] fees = {180, 5000, 10, 600};

        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT"
                , "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN"
                , "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        solution(fees, records);
    }
}
