import java.util.Random;
import java.util.Scanner;

public class Jumin {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        String TempYear = sc.next();
        String year = TempYear.substring(2, 4);

        System.out.print("출생월을 입력해 주세요.(mm):");
        int TempMonth = sc.nextInt();
        String month = null;
        if (TempMonth < 10) {
            month = String.format("%02d", TempMonth);
        }

        System.out.print("출생일을 입력해 주세요.(dd):");
        String day = sc.next();

        System.out.print("성별을 입력해 주세요.(m/f):");
        String gender = sc.next();
        if("m".equals(gender)){         // 입력값은 20년 이후로 입력한다는 전제이므로 남(1) 여(2) 고려하지 않음
            gender = "3";
        } else if ("f".equals(gender)) gender = "4";

        Random rd = new Random();
        int random = rd.nextInt(999999) + 1; // 1부터 999998 사이의 숫자 생성
        String TempNum = String.format("%06d", random); // 숫자를 6자리로 변환, 빈 자리는 0으로 채움

        String JuminNum = (sb.append(year).append(month).append(day).append("-").append(gender).append(TempNum)).toString();

        System.out.println(JuminNum);
    }
}
