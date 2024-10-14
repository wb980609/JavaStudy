import java.util.Scanner;

public class CalculateTax {

    public static int CalTax(int money, int condition, int rates) {
        int result = (int) ((money - condition) * (rates * 0.01));
        System.out.println("\t" + (money - condition) + " * \t" + rates + "% = \t" + result);
        return result;
    }

    public static int CalDeductTax(int money, int deduction, int rates) {
        return (int) ((money * (rates * 0.01)) - deduction);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] brackets = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};   // 세금 구간
        int[] rates = {6, 15, 24, 35, 38, 40, 42, 45};  // 세율
        int[] deductions = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};  // 공제액

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");

        int money = sc.nextInt();
        int tax = 0;
        int deduct_tax = 0;

        for (int i = 0; i < brackets.length; i++) {     // 각 구간별로 세금 계산을 처리하고, 소득이 해당 구간에 속할 때 계산을 멈추도록 break를 걸음
            if (money <= brackets[i]) {

                tax += CalTax(money, i == 0 ? 0 : brackets[i - 1], rates[i]);
                deduct_tax = CalDeductTax(money, deductions[i], rates[i]);
                break;

            } else {

                tax += CalTax(brackets[i], i == 0 ? 0 : brackets[i - 1], rates[i]);
            }
        }

        if (money > brackets[brackets.length - 1]) {    // 가장 높은 소득 구간인 10억을 초과할 때
            tax += CalTax(money, brackets[brackets.length - 1], rates[rates.length - 1]);   // brackets, rates 배열의 마지막 값 input
            deduct_tax = CalDeductTax(money, deductions[deductions.length - 1], rates[rates.length - 1]);
        }

        System.out.println();
        System.out.println(String.format("[세율에 의한 세금]: \t\t\t%d", tax));
        System.out.println(String.format("[누진 공제 셰산에 의한 세금]: \t%d", deduct_tax));
    }


}
