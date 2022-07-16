package linkdein;

import java.util.UUID;

public class CalPow {
    // We can approximate the value by squaring the value and getting next digit

    public static double raiseByPower(double num, int pow) {
        double res = 1;

        while (pow > 0) {
            if (pow%2 == 1) {
                res = res * num;
            }
            num = num * num;
            pow = pow/2;
        }

        return res;
    }

    public static double calPow(double num, double pow) {
        double res = 1;
        for (int i = 0; i < 5; i++) {
//            int x = getClosest
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(raiseByPower(10, 3));
        System.out.println(raiseByPower(10, 5));
        System.out.println(raiseByPower(10, 1));
    }
}
