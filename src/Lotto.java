import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
    public static int[] lottoNumberCreate() {
        int[] inputNumber = new int[6];

        for (int i = 0; i < inputNumber.length; i++) {
            inputNumber[i] = (int) (Math.random() * 45) + 1;
            // 증복 제거
            for (int j = 0; j < i; j++) {
                if (inputNumber[i] == inputNumber[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(inputNumber);
        return inputNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> listNumber = new ArrayList<>(); // 로또 구매 수량에 대한 숫자들을 담을 배열 생성
        char orderNumber = 'A'; // 맨 앞의 기호 초기값
        int[] outputNumber; // 출력 번호


        System.out.println("[로또 당첨 프로그램]\n");
        System.out.println();
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int lotto_num = sc.nextInt();
        if (!(lotto_num > 0 && lotto_num < 11)) {
            System.out.println("1~10 사이의 숫자만 입력해주세요.");
            return;
        }


        // 입력 받은 개수에 따른 로또 번호 랜덤 생성
        for (int i = 0; i < lotto_num; i++) {

            //6개의 랜덤 로또 번호 생성
            listNumber.add(i, lottoNumberCreate());
        }

        // 생성된 로또 번호 출력
        for (int i = 0; i < listNumber.size(); i++) {
            outputNumber = new int[6];
            for (int j = 0; j < outputNumber.length; j++) {
                outputNumber = listNumber.get(i);
                if (j == 0) {
                    System.out.printf("%s\t%02d", orderNumber, outputNumber[j]);
                } else if (j < outputNumber.length - 1) {
                    System.out.printf(",%02d", outputNumber[j]);
                } else {
                    System.out.printf(",%02d\n", outputNumber[j]);
                }
            }
            if (i < listNumber.size() - 1) {
                orderNumber++;
            } else {
                orderNumber = 'A';
                System.out.println();
            }
        }

        //로또 당첨 번호 출력
        System.out.println("[로또 발표]");
        // 당첨 번호 랜덤 생성
        int[] winningNumber;
        winningNumber = lottoNumberCreate();

        for (int i = 0; i < winningNumber.length; i++) {
            if (i == 0) {
                System.out.printf(" \t%02d", winningNumber[i]);
            } else if (i < winningNumber.length - 1) {
                System.out.printf(",%02d", winningNumber[i]);
            } else {
                System.out.printf(",%02d\n\n", winningNumber[i]);
            }
        }

        // 당첨 번호와 구매 로또 번호를 비교하여 숫자 일치 여부 판단
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < listNumber.size(); i++) {
            int cnt = 0;
            outputNumber = listNumber.get(i);

            for (int j = 0; j < outputNumber.length; j++) {
                for (int k = 0; k < outputNumber.length; k++) {
                    if (outputNumber[j] == winningNumber[k]) {
                        cnt++;
                    }
                }
                if (j == 0) {
                    System.out.printf("%s\t%02d", orderNumber, outputNumber[j]);
                } else if (j < outputNumber.length - 1) {
                    System.out.printf(",%02d", outputNumber[j]);
                } else {
                    System.out.printf(",%02d => %d개 일치\n", outputNumber[j], cnt);
                }
            }
            if (i < listNumber.size() - 1) {
                orderNumber++;
            } else {
                orderNumber = 'A';
                System.out.println();
            }
        }
    }
}
