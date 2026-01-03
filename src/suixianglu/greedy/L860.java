package suixianglu.greedy;

public class L860 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }

            if (bills[i] == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            }

            if (bills[i] == 20) {
                if (five == 0 || ten == 0 && five < 3)
                    return false;
                if (ten > 0) {
                    five--;
                    ten--;
                } else five -= 3;
            }
        }
        return true;
    }
}
