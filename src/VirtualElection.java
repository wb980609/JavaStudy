import java.util.Scanner;

public class VirtualElection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("총 진행할 투표수를 입력해 주세요. ");
        int elect_num = sc.nextInt();

        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요. ");
        int candidate_num = sc.nextInt();

        String[] candidateArray = new String[candidate_num];

        for(int i = 1; i <= candidate_num ; i++){
            System.out.print(i+"번째 후보자 이름을 입력해 주세요. ");
            String temp_name = sc.next();
            candidateArray[i-1] = temp_name;
        }

        for(int i = 0; i < candidate_num ; i++) {
            System.out.print(candidateArray[i]+" ");
        }

//        for(int i = 1; i<= elect_num; i++){
//            System.out.println();
//        }
    }
}
