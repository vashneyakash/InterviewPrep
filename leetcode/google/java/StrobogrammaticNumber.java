package google.java;

public class StrobogrammaticNumber {
    /*
    * Optimal solution:
    * Find number of strombatic numbers till x
    * Use Digit DP
    * count number of digits in x
    * for digit number < digits in x:
    *   calculate strombatic numbers
    *
    * specially calculate the strombatic numbers for digit number == digits in x
    *
    * Watched videos for digit DB
    * https://www.youtube.com/watch?v=IjPGC8aN4vA
    * https://www.youtube.com/watch?v=T5R6qZAp0u8   
    * https://www.youtube.com/watch?v=Ukp8SMJT6Ao
    * */

    private final long upperLimit;
    public StrobogrammaticNumber(long upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int calculateStrobogrammaticNumber() {
        return 0;
    }

    public static void main(String[] args) {

    }

}
