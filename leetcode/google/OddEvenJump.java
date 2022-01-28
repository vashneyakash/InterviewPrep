package google;

public class OddEvenJump {
    /*
    * Brute Force Approach :
    * for each index i:
    *   check if someone can get to last index using Check()
    *
    * check(int start) :
    *   if (start == end):
    *       return true
    *   if (start%2 == 0):
    *       get smallest element in array that in smaller or equal to this number
    *       int x
    *       return check(x)
    *   else:
    *       get just greater than this element in the array
    *       int x
    *       return check(x)
    */
}
