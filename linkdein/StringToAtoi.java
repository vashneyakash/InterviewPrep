package linkdein;

public class StringToAtoi {
    public static void main(String[] args) {
        String number = " -0  ";
        number = number.trim();
        boolean isPositive = true;
        if (number.length() > 0 && (number.startsWith("+") || number.startsWith("-"))) {
            if (number.startsWith("-")) isPositive = false;
            number = number.substring(1);
        }

        int num = 0;

        for (int i = 0; i < number.length(); i++) {
            int lastDigit = number.charAt(i) - '0';
            num = num * 10 + lastDigit;
        }
        if (!isPositive) num = -num;
        System.out.println("num = " + num);
    }
}
