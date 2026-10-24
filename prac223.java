
public class prac223 {

    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int startAlice = getDay(arriveAlice);
        int endAlice = getDay(leaveAlice);

        int startBob = getDay(arriveBob);
        int endBob = getDay(leaveBob);

        int start = Math.max(startAlice, startBob);
        int end = Math.min(endAlice, endBob);

        return Math.max(0, end - start + 1);
    }

    private int getDay(String date) {

        int[] days = {31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }

        return day;
    }

    public static void main(String[] args) {

        prac223  obj = new prac223();

        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";

        int result = obj.countDaysTogether(
                arriveAlice, leaveAlice,
                arriveBob, leaveBob
        );

        System.out.println("Days spent together: " + result);
    }
}
