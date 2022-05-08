package javax;

public class bitMasking {
    public static void main(String[] args) {
        int x = 5;
        System.out.println("(5 << 5) : " + (x << 5));
        System.out.println("(125 >> 3) : " + (125 >> 3));
        System.out.println("(125 binary string) : " + Integer.toBinaryString(125));
        System.out.println("(125 >> 3 binary string) : " + Integer.toBinaryString(125 >> 3));
        System.out.println("(64 >> 3) : " + (64 >> 3));
        System.out.println("(14 + 5th bit) : " + (14 | (1 << 5)));
        System.out.println("(14 + 5th bit) : " + Integer.toBinaryString(14 | (1 << 5)));
        System.out.println("(14) : " + Integer.toBinaryString(14));
        System.out.println("(check 14 has 2th bit) : " + (14 & (1 << 2)));
        System.out.println("(14 ka off karo 2th bit) : " + (14 & ~(1 << 2)));
        System.out.println("(14 ka toggle karo 2th bit) : " + (14 ^ (1 << 2)));
        System.out.println("(14 ka toggle karo 2th bit) : " + (14 ^ (1 << 0)));
    }
}
