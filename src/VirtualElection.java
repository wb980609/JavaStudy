import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VirtualElection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("총 진행할 투표수를 입력해 주세요. ");
        int elect_num = sc.nextInt();

        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요. ");
        int candidate_num = sc.nextInt();

        sc.nextLine(); // 버퍼를 비워주기

        ArrayList<String> candidate_arr = new ArrayList<String>(); // 후보자 이름 저장할 List

        for (int i = 1; i <= candidate_num; i++) { //반복문을 이용하여 후보자 이름 삽입
            System.out.print( i + "번째 후보자 이름을 입력해 주세요.");
            String name = sc.nextLine();
            candidate_arr.add(name);

        }

        Random random = new Random();
        int num = 0; //임의 번호가 생성된 후 대입될 변수 선언 및 초기화

        int[] sum = new int[candidate_num]; //투표결과 저장할 배열 선언

        for (int i = 0; i < elect_num; i++) {
            double rate = (double) (i + 1) / elect_num * 100;

            num = random.nextInt(candidate_num) + 1; //1부터 후보자 인원까지 범위의 임의번호 생성


            System.out.printf("[투표진행률] : %.2f%%, %d명 투표 ==> %s\n", rate, (i + 1), candidate_arr.get(num - 1));
            sum[num - 1]++;

            for (int j = 0; j < candidate_num; j++) {

                double personreate = (double) sum[j] / elect_num * 100; //개인당 투표율 계산

                System.out.printf("[기호:%d] %s:", (j + 1), candidate_arr.get(j));

                if (candidate_arr.get(j).length() < 2) {
                    System.out.print("\t\t");
                } else if (candidate_arr.get(j).length() < 4) {
                    System.out.print("\t");
                }

                System.out.printf("\t%.2f%% \t (투표수: %d)\n", personreate, sum[j]);
            }
            System.out.println();


        }

        int max = 0;
        int max_index = 0;
        for (int i = 0; i < sum.length ; i++) {

            if (max < sum[i]) {
                max = sum[i];
                max_index = i;
            }

        }

        System.out.println("[투표결과] 당선인 : " + candidate_arr.get(max_index) );

    }
}
