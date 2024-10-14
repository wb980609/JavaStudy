import java.util.Scanner;

public class CalculateTax {

    public static int CalTax(int money, int condition, int rates){
        int result = 0;
        result  = (int) ((money-condition) * (rates * 0.01));
        System.out.println("\t" + (money - condition)+" * \t"+rates+"% =\t"+result);
        return result;
    }

    public static int CalDeductTax(int money, int deduction, int rates){
        int result = 0;
        result  = (int) ((money * (rates * 0.01)) - deduction);

        return result;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Define the income tax brackets and rates
        int[] brackets = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");

        int tax = 0;
        int deduct_tax = 0;
        int deduction = 0;
        int money = sc.nextInt();

        if(money <= brackets[0]){

            tax = (int) (money * (6*0.01));
            System.out.println("\t" + money + " * "+"\t6% = \t"+tax);
            deduct_tax = tax;

        } else if (brackets[0] < money && money <= brackets[1]) {

            tax = (int)(brackets[0] * (6 * 0.01));
            System.out.println("\t" +brackets[0]+" * "+"\t6% = \t"+tax);
            tax += CalTax(money, brackets[0],15);

            deduction = 1080000;
            deduct_tax = CalDeductTax(money, deduction, 15);

        }else if(brackets[1] < money && money <= brackets[2]){

            tax = (int)(brackets[0] * (6 * 0.01));
            System.out.println("\t" +brackets[0]+" * "+"\t6% = \t"+tax);
            tax += CalTax(brackets[1], brackets[0],15);
            tax += CalTax(money, brackets[1],24);

            deduction = 5220000;
            deduct_tax = CalDeductTax(money, deduction, 24);

        }else if(brackets[2] < money && money <= brackets[3]){

            tax = (int)(brackets[0] * (6 * 0.01));
            System.out.println("\t" +brackets[0]+" * "+"\t6% = \t"+tax);
            tax += CalTax(brackets[1], brackets[0],15);
            tax += CalTax(brackets[2], brackets[1],24);
            tax += CalTax(money, brackets[2],35);

            deduction = 14900000;
            deduct_tax = CalDeductTax(money, deduction, 35);

        }else if(brackets[3] < money && money <= brackets[4]){

            tax = (int)(brackets[0] * (6 * 0.01));
            System.out.println("\t" +brackets[0]+" * "+"\t6% = \t"+tax);
            tax += CalTax(brackets[1], brackets[0],15);
            tax += CalTax(brackets[2], brackets[1],24);
            tax += CalTax(brackets[3], brackets[2],35);
            tax += CalTax(money, brackets[3],38);

            deduction = 19400000;
            deduct_tax = CalDeductTax(money, deduction, 38);

        }else if(brackets[4] < money && money <= brackets[5]){

            tax = (int)(brackets[0] * (6 * 0.01));
            System.out.println("\t" +brackets[0]+" * "+"\t6% = \t"+tax);
            tax += CalTax(brackets[1], brackets[0],15);
            tax += CalTax(brackets[2], brackets[1],24);
            tax += CalTax(brackets[3], brackets[2],35);
            tax += CalTax(brackets[4], brackets[3],38);
            tax += CalTax(money, brackets[4],40);

            deduction = 25400000;
            deduct_tax = CalDeductTax(money, deduction, 40);

        }else if(brackets[5] < money && money <= brackets[6]){

            tax = (int)(brackets[0] * (6 * 0.01));
            System.out.println("\t" +brackets[0]+" * "+"\t6% = \t"+tax);
            tax += CalTax(brackets[1], brackets[0],15);
            tax += CalTax(brackets[2], brackets[1],24);
            tax += CalTax(brackets[3], brackets[2],35);
            tax += CalTax(brackets[4], brackets[3],38);
            tax += CalTax(brackets[5], brackets[4],40);
            tax += CalTax(money, brackets[5],42);

            deduction = 35400000;
            deduct_tax = CalDeductTax(money, deduction, 42);

        }else if(brackets[6] < money ){

            tax = (int)(brackets[0] * (6 * 0.01));
            System.out.println("\t" +brackets[0]+" * "+"\t6% = \t"+tax);
            tax += CalTax(brackets[1], brackets[0],15);
            tax += CalTax(brackets[2], brackets[1],24);
            tax += CalTax(brackets[3], brackets[2],35);
            tax += CalTax(brackets[4], brackets[3],38);
            tax += CalTax(brackets[5], brackets[4],40);
            tax += CalTax(brackets[6], brackets[5],42);

            tax += CalTax(money, brackets[6],45);

            deduction = 65400000;
            deduct_tax = CalDeductTax(money, deduction, 45);
        }
        System.out.println();
        System.out.println(String.format("[세율에 의한 세금]: \t\t\t%d",tax));
        System.out.println(String.format("[누진 공제 셰산에 의한 세금]: \t%d",deduct_tax));

    }


}
