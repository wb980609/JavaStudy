import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {
    public static void displayCalendar(int year, int month) {

        // 매개변수 기준으로 앞뒤 연도와 월 선언하기
        int previousMonth = (month == 1) ? 12 : month - 1;
        int nextMonth = (month == 12) ? 1 : month + 1;
        int previousYear = (month == 1) ? year - 1 : year;
        int nextYear = (month == 12) ? year + 1 : year;

        // 이전 달, 현재 달, 다음 달의 LocalDate 객체 생성하기(일자는 상관없으니 임의로 1로 설정)
        LocalDate ld1 = LocalDate.of(previousYear, previousMonth, 1);
        LocalDate ld2 = LocalDate.of(year, month, 1);
        LocalDate ld13 = LocalDate.of(nextYear, nextMonth, 1);

        // 이전 달, 현재 달, 다음 달의 시작 요일과 마지막 날짜 가져오기
        int firstDay1 = ld1.getDayOfWeek().getValue();
        int lastDate1 = ld1.lengthOfMonth();
        int firstDay2 = ld2.getDayOfWeek().getValue();
        int lastDate2 = ld2.lengthOfMonth();
        int firstDay3 = ld13.getDayOfWeek().getValue();
        int lastDate3 = ld13.lengthOfMonth();

        // 배열에 담기
        int[] months = {previousMonth, month, nextMonth};
        int[] dates = {1, 1, 1};
        int[] lastDates = {lastDate1, lastDate2, lastDate3};
        int[] days = {firstDay1, firstDay2, firstDay3};

        // 달력 첫 줄 만들기
        System.out.print("[" + previousYear + "년 " + String.format("%02d", (previousMonth)) + "월]" + "\t\t\t\t\t");
        System.out.print("[" + year + "년 " + String.format("%02d", month) + "월]" + "\t\t\t\t\t");
        System.out.println("[" + nextYear + "년 " + String.format("%02d", (nextMonth)) + "월]");

        System.out.print("일\t월\t화\t수\t목\t금\t토\t\t");
        System.out.print("일\t월\t화\t수\t목\t금\t토\t\t");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for (int j = 0; j < 3; j++) { // 세 달 모두 할 때까지
            int i = 0;
            if (days[j] > 6) { // 해당 달의 시작 요일 값이 7 이상인 경우
                days[j] = days[j] - 7; // 줄바꿈 없이 바로 첫 번째 줄에서 시작하도록 값 조정
            }
            while (i < days[j]) { // 1. 시작 요일까지 공백 넣기
                System.out.print("\t");
                i++;
            }
            for (i = 0; i < lastDates[j]; dates[j]++, i++) {
                System.out.printf("%02d\t", dates[j]); // 2. 날짜 넣기
                days[j]++;
                if (days[j] % 7 == 0) {
                    System.out.print("\t"); // 3. 다음 달과 간격두기
                    dates[j]++;
                    break;
                }
            }
        }
        System.out.println(); // 첫 줄 완성

        // 달력 둘째 줄 ~ 나머지 줄 만들기
        for (int k = 0; k < 5; k++) { // 아래로 몇 번 (행)
            for (int j = 0; j < 3; j++) { // 옆으로 몇 번 (열)
                for (int i = 0; i < lastDates[j]; i++) { // 해당 월 마지막 날짜까지
                    if (dates[j] == 0) { // 이미 날짜 표기가 끝났는지 먼저 확인
                        System.out.print("\t\t\t\t\t\t\t\t");
                        break;
                    } else if (dates[j] <= lastDates[j]) {
                        System.out.printf("%02d\t", dates[j]); // 날짜 넣기
                        dates[j]++; // 날짜 증가
                        days[j]++; // 요일 증가
                    }
                    if (dates[j] > lastDates[j]) { // 날짜를 넣다가 -> 마지막 날짜를 표기할 차례라면
                        for (int n = 0; n <= (35 - days[j]); n++) { // 5주차 일요일에서 해당 요일까지 차이 계산
                            System.out.print("\t"); // 빈 요일에 공백 추가
                        }
                        dates[j] = 0;
                        break; // 다음 열로
                    }
                    if (days[j] % 7 == 0) { // 날짜를 넣다가 -> 토요일이면
                        System.out.print("\t"); // 공백 하나만 추가
                        break; // 다음 열로
                    }
                }
            }
            System.out.println(); // 나머지 줄 완성
        }
    }

    public static void main(String[] args) {
        int year;
        int month;

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("[달력 출력 프로그램]");
            System.out.print("달력의 년도를 입력해 주세요. (yyyy) : ");
            year = sc.nextInt();
            // 년도 음수 입력 방지
            if(year < 0) {
                System.out.println("년도 입력이 잘못되었습니다. 다시 시작합니다.\n");
                continue;
            }

            System.out.print("달력의 월을 입력해 주세요. (mm) : ");
            month = sc.nextInt();
            // 월 1~12 외 입력 방지
            if(month <= 0 || month > 12) {
                System.out.println("월 입력이 잘못되었습니다. 다시 시작합니다.\n");
                continue;
            }
            break;
        }

        System.out.println();
        displayCalendar(year, month);
    }
}
