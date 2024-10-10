import java.util.Scanner;

public class CashBack {
    public static void main(String[] args) {

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        Scanner sc = new Scanner(System.in);
        int cash = sc.nextInt();

        int cashBack = (int)(cash * 0.1) > 300 ? 300 : (((int)(cash * 0.1) / 100) * 100);

        System.out.println(String.format("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", cash, cashBack));

    }
}
