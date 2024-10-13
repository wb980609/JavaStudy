import java.util.Scanner;

class AmusementPark {
    public static void main(String[] args) {

        int charge;
        Scanner sc = new Scanner(System.in);

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = sc.nextInt();

        System.out.print("입장시간을 입력해 주세요.(숫자):");
        int time = sc.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String merit = sc.next();     // person of merit

        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String welfare = sc.next();

        if(age < 3) {
            charge = 0;
        }
        else{
            if(age < 13 || time >= 17){     // 특별할인 적용 조건
                charge = 4000;
            } else if(merit.equals("y") || welfare.equals("y")){        // 일반할인 적용 조건
                charge = 8000;
            } else {
                charge = 10000;
            }
        }

        System.out.print("입장료: " + charge);
    }
}
