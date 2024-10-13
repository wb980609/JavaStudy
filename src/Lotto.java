import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]");
        System.out.println();
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");    // 로또 구매 수량 입력
        int lotto_num = sc.nextInt();

        int[] lotto_arr = new int[6];
        int[][] myLottoArr = new int[lotto_num][6];

        // 로또
        for (int i = 0; i < lotto_num; i++) {
            for (int j = 0; j < myLottoArr[i].length; j++) {
                myLottoArr[i][j] += (int)(Math.random() * 45) + 1;

                //중복방지
                for (int k = 0; k < j; k++) {
                    if (myLottoArr[i][j] == myLottoArr[i][k])
                    {
                        j--;
                        break;
                    }
                }

            }
            Arrays.sort(myLottoArr[i]);
        }

        // 로또 결과 출력
        for (int i = 0; i < lotto_num; i++) {
            System.out.print((char)(i + 65) + "\t");
            for (int j = 0; j < myLottoArr[i].length; j++) {
                if(j == 5) {
                    System.out.printf("%02d\n", myLottoArr[i][j]);
                }
                else
                    System.out.printf("%02d, ", myLottoArr[i][j]);
            }
        }

        System.out.println();
        System.out.println("[로또 발표]");
        System.out.print("\t");    //문자 출록

        // 로또 당첨번호 생성
        for (int i = 0; i < lotto_arr.length; i++) {
            lotto_arr[i] += (int)(Math.random() * 45) + 1;

            //중복방지
            for (int k = 0; k < i; k++) {
                if (lotto_arr[i] == lotto_arr[k])
                {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lotto_arr);     // 정렬

        for (int i = 0; i < 6; i++) {
            if(i == 5) {
                System.out.printf("%02d\n", lotto_arr[i]);
            }
            else
                System.out.printf("%02d, ", lotto_arr[i]);
        }

        System.out.println();
        System.out.println("[내 로또 결과]");


        for (int i = 0; i < lotto_num; i++) {
            int iSame = 0;
            System.out.print((char)(i + 65) + "\t");
            for (int j = 0; j < 6; j++) {

                if(lotto_arr[i] == myLottoArr[i][j])    // 당첨 번호와 구매 로또 일치 여부 판단
                {
                    iSame++;
                }

                if(j == 5) {
                    System.out.printf("%02d", myLottoArr[i][j]);
                    System.out.printf(" => %d개 일치 \n", iSame);
                }
                else {
                    System.out.printf("%02d, ", myLottoArr[i][j]);
                }
            }

        }

        System.out.println();
    }
}
