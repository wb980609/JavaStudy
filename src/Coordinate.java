import java.util.*;

class Point {
    int x;
    int y;
}
public class Coordinate {

    public static boolean isDuplicate (HashSet<Point> s, Point p) {

        Iterator<Point> it = s.iterator();
        while (it.hasNext()) {
            Point curPoint = it.next();

            if (p.x == curPoint.x && p.y == curPoint.y) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Point myPoint  = new Point();
        Point minPoint = new Point();
        double minLen  = Integer.MAX_VALUE;

        // 나의 좌표 입력
        System.out.print("[나의 좌표] x값을 입력해 주세요.: ");
        myPoint.x = sc.nextInt();

        System.out.print("[나의 좌표] y값을 입력해 주세요.: ");
        myPoint.y = sc.nextInt();

        // 임의의 좌표 10개 입력
        int cnt = 1;
        HashSet<Point> set = new HashSet<>();
        while(set.size() < 10) {
            Point tmpPoint = new Point();
            System.out.printf("[임의의 좌표 %d] x값을 입력해 주세요.: ", cnt);
            tmpPoint.x = sc.nextInt();

            System.out.printf("[임의의 좌표 %d] y값을 입력해 주세요.: ", cnt);
            tmpPoint.y = sc.nextInt();


            if (!isDuplicate(set, tmpPoint)) {
                set.add(tmpPoint);
                cnt++;
            } else {
                System.out.printf("[임의의 좌표 %d] 중복입니다. 다시 입력해 주세요.", cnt);
                System.out.println();
            }
        }

        Iterator<Point> it = set.iterator();
        while (it.hasNext()) {
            Point curPoint = it.next();
            double curLen = Math.pow(Math.abs(myPoint.x - curPoint.x), 2) + Math.pow(Math.abs(myPoint.y - curPoint.y), 2);

            if (curLen < minLen) {
                minLen = curLen;
                minPoint = curPoint;
            }
        }

        System.out.printf("나와 가장 가까운 좌표값은 (%d,%d)입니다.", minPoint.x, minPoint.y);
    }
}